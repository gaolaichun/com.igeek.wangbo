package com.wx.auth.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.auth.util.AuthUtil;

@WebServlet("/wxLogin")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//http://brucebsc.eicp.net需要换成我们的可以访问的公网地址
		String backUrl = "http://brucebsc.eicp.net/WxAuth/callBack";
		
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AuthUtil.APPID
				+ "&redirect_uri="+URLEncoder.encode(backUrl)
				+ "&response_type=code"
				+ "&scope=snsapi_userinfo"
				+ "&state=STATE#wechat_redirect";
		
		resp.sendRedirect(url);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
