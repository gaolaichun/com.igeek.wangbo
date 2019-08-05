package com.wx.auth.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class AuthUtil {
	public static final String APPID = "wxfe5c47f91d3e607a";
	public static final String APPSECRET = "6d46c1e4eae0d34eeed69f00796f2b5c";
	
	public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException {
		JSONObject jsonObject = null;
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = client.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if(entity != null) {
			String result = EntityUtils.toString(entity,"UTF-8");
			jsonObject = JSONObject.fromObject(result);
		}
		httpGet.releaseConnection();
		return jsonObject;
		
	}
}
