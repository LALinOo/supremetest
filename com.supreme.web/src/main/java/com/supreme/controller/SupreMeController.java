package com.supreme.controller;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpHeader;
import com.arronlong.httpclientutil.exception.HttpProcessException;

@Controller
public class SupreMeController {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String Test() {
		System.out.println("caonima");
		// 请求头

		// 请求参数

		// 设置COOKIE
		// HttpClientContext context=new HttpClientContext();

		Header[] headers = HttpHeader.custom().cookie(
				"__utma=74692624.1679350852.1520268431.1520268431.1520268431.1; __utmc=74692624; __utmz=74692624.1520268431.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; __utmb=74692624.1.10.1520268431")
				.host("Host: www.supremenewyork.com")
				.connection("keep-alive")
				.accept("*/*;q=0.5, text/javascript, application/javascript, application/ecmascript, application/x-ecmascript")
				.other("Origin", "http://www.supremenewyork.com")
				.other("X-CSRF-Token", "gTXZ6UbQ71XZkrIokgFwE4AXX9lKyozWe0NmPOmUqEpkAuVoBnApzMFGBeQxeQPUBWWGNDebJDMipnkdRNDJWw==")
				.other("X-Requested-With", " XMLHttpRequest")
				.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36")
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.referer("http://www.supremenewyork.com/shop/accessories/x5fy32h08/u2xc8r14q")
				.build();

		HCB hcb = null;
		try {
			hcb = HCB.custom().timeout(10000).pool(100, 10).retry(5).proxy("127.0.0.1", 8888);
		} catch (HttpProcessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpClient client = hcb.build();
		
		// 超时
		// 启用连接池，每个路由最大创建10个链接，总连接数限制为100个
		// https，支持自定义ssl证书路径和密码，ssl(String keyStorePath, String keyStorepass)
		// 重试5次

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("utf8", "✓");
		map.put("st", "18393");
		map.put("s", "50881");
		map.put("commit", "カートに入れる");
		HttpConfig config = HttpConfig.custom().url("http://www.supremenewyork.com/shop/4852/add").map(map)
				.client(client).encoding("utf-8").headers(headers);
		String result2 = "";
		try {
			result2 = HttpClientUtil.post(config);
		} catch (HttpProcessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // post请求
		System.out.print(result2);
		return "showStudentInfo";
	}
}
