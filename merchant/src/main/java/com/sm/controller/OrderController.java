package com.sm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sm.model.Order;
import com.sm.model.Shop;
import com.sm.model.User;
import com.sm.service.OrderService;
import com.sm.service.ShopService;
import com.sm.service.UserService;
import com.sm.util.Common;
import com.sm.util.Msg;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	
	/**
	 * 营业额、有效订单、无效订单
	 * @param id 商家id
	 * @param type 今日1   7日 7      昨日2
	 * @return
	 */
	@RequestMapping("/getTurnover")
	@ResponseBody
	public Msg getTurnover(Integer id,Integer type) {
		if(id==null || type==null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		//营业额
		double total = 0 ;
		//有效订单数
		int validOrder = 0;
		//无效订单数
		int voidOrder = 0;
		if(type==1) {
			List<Order>list1=orderService.todayOrder(id,1);
			for(int i=0;list1.size()>i;i++) {
				double price = list1.get(i).getPrice();
				total+=price;
			}
			validOrder=list1.size();
			voidOrder=orderService.todayOrder(id, 3).size();
			
		}else if(type==7) {
			List<Order>list2=orderService.seventOrder(id,1);
			for(int i=0;list2.size()>i;i++) {
				double price = list2.get(i).getPrice();
				total+=price;
			}
			validOrder=list2.size();
			voidOrder=orderService.seventOrder(id, 3).size();
		}else {
			List<Order>list3=orderService.yesterOrder(id,1);
			for(int i=0;list3.size()>i;i++) {
				double price = list3.get(i).getPrice();
				total+=price;
			}
			validOrder=list3.size();
			voidOrder=orderService.yesterOrder(id, 3).size();
		}
		return Msg.success().add("total", total).add("validOrder", validOrder).add("voidOrder", voidOrder);
	}
	
	/**
	 * 今日经营
	 * @param id 商户id
	 * @return
	 */
	@RequestMapping("/todayOrder")
	@ResponseBody
	public Msg todayManage(Integer id) {
		if(id==null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		//今日总营业额、数量、客单价
		double todayTotal = 0;
		int todayOrder = 0;
		double todaySingle = 0;
		List<Order>list1 = orderService.todayOrder(id, 1);
		if(list1.size()==0) {
			todayOrder = 0;
			todaySingle = 0;
			todayTotal = 0;
		}else {
			for(int i=0;list1.size()>i;i++) {
				double price = list1.get(i).getPrice();
				todayTotal += price;
			}
			todayOrder = list1.size();
			todaySingle = Common.divide(todayTotal, todayOrder, 2);
		}
		
		//昨日营业额、数量、客单价
		double yesterTotal = 0;
		int yesterOrder = 0;
		double yesterSingle = 0;
		List<Order>list2=orderService.yesterOrder(id, 1);
		if(list2.size()==0) {
			yesterTotal = 0;
			yesterOrder = 0;
			todaySingle = 0;
		}else {
			for(int i=0;list2.size()>i;i++) {
				double price = list2.get(i).getPrice();
				yesterTotal+=price;
			}
			yesterOrder = list2.size();
			yesterSingle=Common.divide(yesterTotal, yesterOrder, 2);
		}
		return Msg.success().add("todayTotal", todayTotal).add("todaySingle", todaySingle).add("todayOrder", todayOrder).add("yesterTotal", yesterTotal).add("yesterOrder", yesterOrder).add("yesterSingle", yesterSingle);
	}
	
	/**
	 * 商家订单
	 * @param sid 商户id
	 * @param orderStatus 状态
	 * @return
	 */
	@RequestMapping("/merchantOrder")
	@ResponseBody
	public Msg merchantOrder(Integer sid,Integer orderStatus,String payTime) {
		if(sid==null || orderStatus==null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		//PageHelper.startPage(pageNum, pageSize);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Order order = new Order();
		order.setOrderStatus(orderStatus);
		order.setSid(sid);
		try {
			order.setPayTime(sdf.parse(payTime));
		} catch (ParseException e) {
			
			e.printStackTrace();
			return Msg.fail().add("msg", "时间转换出错！");
		}
		List<Order>list = orderService.merchantOrder(order);
		
		return Msg.success().add("orderList", list);
	}
	
	/**
	 * 参与者个人信息
	 * @param allUid 参与者id集合
	 * @return
	 */
	@RequestMapping("/getParticipant")
	@ResponseBody public Msg getParticipant(String allUid) {
		if(allUid==null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		List<User> userList = new ArrayList<User>();
		User user = new User();
		String[] split=allUid.split(",");
		for(int i = 0; i < split.length; i++) {
			String a = split[i];
			int uid = Integer.parseInt(a);
			user = userService.selectByPrimaryKey(uid);
			userList.add(user);
		}
		return Msg.success().add("userList", userList);
	}
	
	/**
	 * 搜索订单
	 * @param orderNo 输入值
	 * @return
	 */
	@RequestMapping("/searchOrder")
	@ResponseBody
	public Msg searchOrder(String orderNo) {
		if(orderNo==null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		Order order = orderService.searchOrder(orderNo);
		return Msg.success().add("order", order);
	}
	
}
