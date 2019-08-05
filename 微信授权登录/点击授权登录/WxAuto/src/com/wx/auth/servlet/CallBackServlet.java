package com.wx.auth.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.auth.util.AuthUtil;

import net.sf.json.JSONObject;

@WebServlet()
public class CallBackServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String code = req.getParameter("clde");
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AuthUtil.APPID
				+ "&secret="+AuthUtil.APPSECRET
				+ "&code="+code
				+ "&grant_type=authorization_code";
		JSONObject jsonObject = AuthUtil.doGetJson(url);
		String openid = jsonObject.getString("openid");
		String token = jsonObject.getString("access_token");
		String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+token
				+ "&openid="+openid
				+ "&lang=zh_CN";
		JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
		System.out.println(userInfo);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
