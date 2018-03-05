package com.supreme.controller;


import java.net.CookieStore;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Header;

import org.apache.http.client.protocol.HttpClientContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpCookies;

@Controller
public class SupreMeController {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String Test() {
		System.out.println("caonima");
		//请求头
		
		//请求参数
		
		//设置COOKIE
		HttpClientContext context=new HttpClientContext();
		
		HttpCookies cookie=HttpCookies.custom().setContext(context);
		cookie.setCookieStore(cookieStore)
		Map<String,Object> map=new HashMap<String,Object>();
		HttpConfig config = HttpConfig.custom()
		.url("http://www.supremenewyork.com/shop/171219/add").map(map).encoding("utf-8").context(HttpCookies.custom().getContext()) 
		return "showStudentInfo";
	}
}
