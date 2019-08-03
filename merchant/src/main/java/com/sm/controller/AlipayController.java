package com.sm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.sm.util.CommonUtil;
import com.sm.util.Msg;


@Controller
public class AlipayController {

	/** 支付宝支付业务：入参app_id */
    public static final String APPID = "";

    /** 支付宝网关*/
    public static final String GATE = "https://openapi.alipay.com/gateway.do";

    /** 商户应用私钥*/
    public static final String APP_PRIVATE_KEY = "";
	

    /** 支付宝公钥 */
    public static final String ALIPAY_PUBLIC_KEY = "";

    /** 编码方式 */
    public static final String CHARSET = "utf-8";
	
    /** 商户外网可以访问的异步地址 */
    public static final String NotifyUrl = "120.78.123.251:8080/piclib/validateAlipayOrder";
    
  
  
    
    /**
     * 发起支付的接口
     * @param body 描述
     * @param price 订单价格
     * @param subject 商品简称
     * @return
     */
	@RequestMapping("/getAlipayOrder")
	@ResponseBody
	public Msg getAlipayOrder(@RequestParam("userId")Integer userId,
			                  @RequestParam("total_fee")String total_fee
			                 ){
		
		
		String outTrandNo = CommonUtil.getOutTradeNo();
		total_fee="0.01";
		Date nowTime = new Date();
		
		
		//实例化客户端
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APPID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, "RSA2");
		//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("会员");
		model.setSubject("价格");
		model.setOutTradeNo(outTrandNo);
		model.setTimeoutExpress("30m");
		model.setTotalAmount(total_fee);
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		request.setNotifyUrl(NotifyUrl);
		try {
		        //这里和普通的接口调用不同，使用的是sdkExecute
		        AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
		        //System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
		        if(response.isSuccess()){
		               System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
		               return Msg.success().add("msg", response.getBody());
		            }else{
		              System.out.println("下单错误");
		              return Msg.fail();
		            }
		    } catch (AlipayApiException e) {
		        e.printStackTrace();
		        return Msg.fail();
		}	
	}
	
	
	/**
	 * 支付宝回调接口
	 * @param request
	 * @return
	 */
	@RequestMapping("/validateAlipayOrder")
	@ResponseBody
	public String validateAlipayOrder(HttpServletRequest request){
		
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
		    String name = (String) iter.next();
		    String[] values = (String[]) requestParams.get(name);
		    String valueStr = "";
		    for (int i = 0; i < values.length; i++) {
		        valueStr = (i == values.length - 1) ? valueStr + values[i]
		                    : valueStr + values[i] + ",";
		  	}
		    //乱码解决，这段代码在出现乱码时使用。
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		//切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
		//boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
		boolean flag;
		try {
			flag = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET,"RSA2");
		} catch (AlipayApiException e) {
			e.printStackTrace();
			return "failure";
		}
		
		if(flag){
			//交易状态
			String trade_status=params.get("trade_status");
			if(trade_status.equals("TRADE_SUCCESS")){
				//支付完成，这里写自己程序的逻辑
				
				return "success";
			}else{
				return "failure";
			}
		}else{
			return "failure";
		}
	}
	
}
