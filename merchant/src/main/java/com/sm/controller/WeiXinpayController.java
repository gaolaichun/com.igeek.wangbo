package com.sm.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.JDOMException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sm.util.WeixinPayUtil;
import com.sm.util.CommonUtil;
import com.sm.util.Msg;

@Controller
public class WeiXinpayController {

	/*微信支付回调路径*/
	public static final String notify_url="120.78.123.251:8080/piclib/validateWeixinOrder";
	
	
	
	/**
	 * 微信支付
	 * @param request
	 * @return
	 */
	@RequestMapping("/getWeixinOrder")
	@ResponseBody
	public Msg getWeixinOrder(@RequestParam("userId")Integer userId,
			                  @RequestParam("vipType")Integer vipType,
			                  @RequestParam("addressId")Integer addressId,
			                  @RequestParam("payType")Integer payType,
			                  HttpServletRequest request){
		
		//微信下单订单号
		String out_trade_no = CommonUtil.getOutTradeNo();
		//订单金额
		String price = request.getParameter("total_fee");
		price="0.01";
		if(userId==null || price==null || addressId==null || payType==null){
			return Msg.fail().add("msg", "参数不为空");
		}
		
		Date nowTime = new Date();
		
		
		int price100 = new BigDecimal(price).multiply(new BigDecimal(100)).intValue();
        if(price100<=0){
        	return Msg.fail().add("msg", "订单金额错误");
        }
        float sessionmoney = Float.parseFloat(price);  
        String finalmoney = String.format("%.2f", sessionmoney);  
        finalmoney = finalmoney.replace(".", "");  
        int intMoney = Integer.parseInt(finalmoney);
        
        String total_fee = String.valueOf(intMoney);  
        String spbill_create_ip = request.getRemoteAddr();
        
        String result = WeixinPayUtil.createPayOrder(out_trade_no,total_fee,spbill_create_ip,notify_url);
        
        try {
	         Map<String, String> map = WeixinPayUtil.doXMLParse(result);
	         SortedMap<Object, Object> parameterMap = new TreeMap<Object, Object>();  
	         parameterMap.put("appid", WeixinPayUtil.APP_ID);
	         parameterMap.put("partnerid", WeixinPayUtil.PARTNER);  
	         parameterMap.put("prepayid", map.get("prepay_id"));  
	         parameterMap.put("package", "Sign=WXPay");  
	         parameterMap.put("noncestr", WeixinPayUtil.createNoncestr());
	         parameterMap.put("timestamp", Long.parseLong(String.valueOf(System.currentTimeMillis()).toString().substring(0,10)));  
	         String sign = WeixinPayUtil.createSign("UTF-8",parameterMap);
	         parameterMap.put("sign", sign); 
	         
	         return Msg.success().add("map", parameterMap);	         	  
	         
         } catch (JDOMException e) {
            e.printStackTrace();
            return Msg.fail();
         } catch (IOException e) {
            e.printStackTrace();
            return Msg.fail();
         }
    }
	
	/**
	 * 微信回调(lx)
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws JDOMException
	 */
	@RequestMapping("/validateWeixinOrder")
	@ResponseBody
	public void validateWeixinOrder(HttpServletRequest request,HttpServletResponse response) throws IOException, JDOMException{
		
		 InputStream inputStream ;  
	        StringBuffer sb = new StringBuffer();  
	        inputStream = request.getInputStream();  
	        String s ;  
	        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));  
	        while ((s = in.readLine()) != null){  
	            sb.append(s);  
	        }  
	        in.close();  
	        inputStream.close();  
	        Map<String, String> m = new HashMap<String, String>();  
	        m = WeixinPayUtil.doXMLParse(sb.toString()); 
	        
	        for(Object keyValue : m.keySet()){
	            System.out.println(keyValue+"="+m.get(keyValue));
	        }

	        SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();        
	        Iterator it = m.keySet().iterator();  
	        while (it.hasNext()) {  
	            String parameter = (String) it.next();  
	            String parameterValue = m.get(parameter);  

	            String v = "";  
	            if(null != parameterValue) {  
	                v = parameterValue.trim();  
	            }  
	            packageParams.put(parameter, v);  
	        }  

	        String resXml = "";  
	        if(WeixinPayUtil.isTenpaySign("UTF-8", packageParams)) {
	             if("SUCCESS".equals((String)packageParams.get("result_code"))){ 
	                 String mch_id = (String)packageParams.get("mch_id"); 
	                 String openid = (String)packageParams.get("openid");  
	                 String out_trade_no = (String)packageParams.get("out_trade_no"); 
	                 String total_fee = (String)packageParams.get("total_fee");  
	                 String transaction_id = (String)packageParams.get("transaction_id"); 

	                 if(!WeixinPayUtil.PARTNER.equals(mch_id)){
	                      resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"  
	                                 + "<return_msg><![CDATA[参数错误]]></return_msg>" + "</xml> ";  
	                      System.out.println("参数错误");
	                 }else{
	                	  resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"  
	                	   				+ "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";  
	                	  System.out.println("订单处理成功");
	                	  
	                	  /*此处可写支付完成后的逻辑*/
	  	                  /*注意：同样的通知可能会多次发送给商户系统。商户系统必须能够正确处理重复的通知*/
	  	                  
	                	  
	                	 
	                 }  
	             }else {  
	                 resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"  
	                         + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";  
	                 System.out.println("支付失败,错误信息：" + packageParams.get("err_code"));
	                 
	             }  
	        } else{  
	            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"  
	                    + "<return_msg><![CDATA[通知签名验证失败]]></return_msg>" + "</xml> "; 
	            System.out.println("ͨ通知签名验证失败");
	        }   

	        BufferedOutputStream out = new BufferedOutputStream(  
	                response.getOutputStream());  
	        out.write(resXml.getBytes());  
	        out.flush();  
	        out.close();  	
	}
}
