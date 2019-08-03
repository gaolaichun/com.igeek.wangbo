package com.sm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.exceptions.ClientException;
import com.sm.model.Shop;
import com.sm.model.ShopBill;
import com.sm.service.ShopBillService;
import com.sm.service.ShopService;
import com.sm.util.CommonUtil;
import com.sm.util.Msg;
import com.sm.util.SMSBean;
import com.sm.util.SendMSMUtil;

@Controller
public class WalletController {

	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopBillService shopBillService;
	
	/**
	 * 商户信息,根据商户id
	 * @param id
	 * @return
	 */
	 @RequestMapping("/getShop")
	 @ResponseBody public Msg getShop(Integer id) { 
		 if(id==null) {
			 return Msg.fail().add("msg", "参数不为空！");
		 } 
		 Shop shop =shopService.selectByPrimaryKey(id); 
		 return Msg.success().add("shop", shop);
	 }
	 
	 /**
	  * 商户账单
	  * @param id 商户id
	  * @param statusSettlement 0未结算，1已结算
	  * @return
	  */
	 @RequestMapping("/getBill")
	 @ResponseBody
	 public Msg getBill(Integer id,Integer statusSettlement) {
		if(id==null || statusSettlement==null) {
			return Msg.fail();
		}
		ShopBill sb = new ShopBill();
		sb.setStatusSettlement(statusSettlement);
		sb.setSid(id);
		List<ShopBill> list = shopBillService.selectByExample(sb);
		return Msg.success().add("billList", list);
	 }
	 
	 /**
	  * 账单详情
	  * @param id 账单id
	  * @return
	  */
	 @RequestMapping("/getShopBill")
	 @ResponseBody
	 public Msg getShopBill(Integer id) {
		if(id==null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		ShopBill shopBill = shopBillService.selectByPrimaryKey(id);
		return Msg.success().add("shopBill", shopBill);
	 }
	 
	 /**
		 * 短信接口
		 * @param phonenum
		 * @param type  1是注册  2是找回密码
		 * @param request
		 * @return
		 */
		@RequestMapping("/getCode")
		@ResponseBody
		public Msg getCode(String phone,
				           String type,
				           HttpServletRequest request) {
			if(phone == null || "".equals(phone)) {
				return Msg.fail().add("msg", "手机号码不能为空");
			}
			String smsTpl = null;
			if(type.equals("1")){
				//登录短信模板
				smsTpl = SendMSMUtil.COMMON_TEMPLATE;
			}else if(type.equals("2")){
				smsTpl = SendMSMUtil.COMMON_TEMPLATE_UPDATE;
			}else{
				smsTpl = SendMSMUtil.COMMON_TEMPLATE_CHECK;
			}
			try{
		        SMSBean smsBean = SendMSMUtil.sendMSM(phone, smsTpl, true, null);
		        if (smsBean == null) {
		        	return Msg.fail().add("msg", "短信发送失败");
		        } else {
		        	return Msg.success();
		        }
		      }catch (ClientException e){
		        e.printStackTrace();
		        return Msg.fail().add("msg", "短信发送失败");
		      }
		}
	 
	 /**
	  * 绑定支付宝
	  * @param zfb 支付宝账号
	  * @param code 验证码
	  * @param phone 手机号
	  * @param id 商户id
	  * @return
	  */
	 @RequestMapping("/bindingZfb")
	 @ResponseBody
	 public Msg bindingZfb(Integer id,String zfb,String code,String phone) {
		 if(id==null || zfb==null || code==null || phone==null) {
			 return Msg.fail().add("msg", "参数不为空！");
		 }
		 //短信验证
		 String msg = CommonUtil.verifyMobileCode(phone, code);
		 if(msg != null) {
			 return Msg.fail().add("msg", msg);
		 }
		 Shop shop = new Shop();
		 shop.setId(id);
		 shop.setZfb(zfb);
		 int a = shopService.updateByPrimaryKeySelective(shop);
		 if(a==1) {
			 return Msg.success();
		 }else {
			 return Msg.fail();
		 } 
	 }
	 
     /**
	 * 短信验证
	 * @param phone 手机号
	 * @param code 验证码
	 * @return
	 */
	 @RequestMapping("/checkCode")
	 @ResponseBody
	 public Msg checkCode(String phone,String code) {
		 if(phone==null || code==null) {
			return Msg.fail().add("msg", "参数不为空！");
		 }
		 String msg = CommonUtil.verifyMobileCode(phone, code);
		 if(msg != null) {
			return Msg.fail().add("msg", msg);
		 }
		 return Msg.success();
	 }
	 
	 /**
	  * 设置支付密码
	  * @param id 商家id
	  * @param payPassword 支付密码
	  * @return
	  */
	 @RequestMapping("/setPayPassword")
	 @ResponseBody
	 public Msg setPayPassword(Integer id,String payPassword) {
		 if(payPassword==null || !payPassword.equals("")) {
			 return Msg.fail().add("msg", "参数不为空！");
		 }
		 Shop shop = new Shop();
		 shop.setId(id);
		 shop.setPayPassword(payPassword);
		 int a = shopService.updateByPrimaryKeySelective(shop);
		 if(a==1) {
			 return Msg.success();
		 }else {
			 return Msg.fail();
		 } 
	 }
	 
	 /**
	  * 修改支付密码前的验证
	  * @param id
	  * @param payPassword(前段md5)
	  * @return
	  */
	 @RequestMapping("/checkPayPassword")
	 @ResponseBody
	 public Msg checkPayPassword(Integer id,String payPassword) {
		 if(id==null || payPassword==null) {
			 return Msg.fail().add("msg", "参数不为空！");
		 }
		 Shop shop = shopService.selectByPrimaryKey(id);
		 if(payPassword.equals(shop.getPayPassword())) {
			 return Msg.success();
		 }else {
			 return Msg.fail().add("msg", "密码不正确！");
		 }
	 }
	 
	 /**
	  * 手动提现
	  * @param id 商户id
	  * @param money 提现金额
	  * @return
	  */
	 @RequestMapping("/manualWithdraw")
	 @ResponseBody
	 public Msg manualWithdraw(Integer id,Double money,String zfbAccount) {
		 if(id==null || money==null) {
			 return Msg.fail().add("msg", "参数不为空！");
		 }
		 Shop shop = shopService.selectByPrimaryKey(id);
		 double totalMoney = shop.getWallet();
		 ShopBill shopBill = new ShopBill();
		 shopBill.setSid(id);
		 shopBill.setTypeTranscation(3);
		 shopBill.setDescribeTranscation("提现");
		 shopBill.setMoney(money);
		 shopBill.setTotalMoney(totalMoney);
		 shopBill.setStatusTranscation(2);
		 shopBill.setStatusSettlement(null);
		 shopBill.setZfbAccount(zfbAccount);
		 shopBill.setCreateTime(new Date());
		 int a = shopService.insertSelective(shop);
		 if(a==1) {
			 return Msg.success();
		 }else {
			 return Msg.fail();
		 } 
	 }
	 
	 /**
	  * 七日流水
	  * @param id
	  * @return
	  */
	 @RequestMapping("/sevenBill")
	 @ResponseBody
	 public Msg sevenBill(Integer id) {
		 if(id==null) {
			 return Msg.fail().add("msg", "参数不为空！");
		 }
		 List<ShopBill> list = shopBillService.sevenBill(id);
		 return Msg.success().add("billList", list);
	 }
	 
	 
	 /**
	       * 自定义流水
	  * @param startTime
	  * @param endTime
	  * @param id
	  * @return
	  */
	 @RequestMapping("/customBill")
	 @ResponseBody
	 public Msg customBill(String startTime,String endTime,Integer id) {
		 if(id==null || startTime==null || endTime==null) {
			 return Msg.fail().add("msg", "参数不为空！");
		 }
		 List<ShopBill> list = shopBillService.customBill(startTime, endTime, id);
		 return Msg.success().add("msg", list);
	 }
}
