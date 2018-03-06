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
		// 璇锋眰澶�

		// 璇锋眰鍙傛暟

		// 璁剧疆COOKIE
		// HttpClientContext context=new HttpClientContext();

		Header[] headers = HttpHeader.custom().cookie(
				"mp_c5c3c493b693d7f413d219e72ab974b2_mixpanel=%7B%22distinct_id%22%3A%20%22161fa0c24081d-05e501b3596b9a-414f0120-ffc00-161fa0c240ac0%22%2C%22Store%20Location%22%3A%20%22US%20Web%22%2C%22Platform%22%3A%20%22Web%22%2C%22%24initial_referrer%22%3A%20%22%24direct%22%2C%22%24initial_referring_domain%22%3A%20%22%24direct%22%7D; __utmt=1; __utma=74692624.398576083.1520318557.1520318557.1520318557.1; __utmb=74692624.1.10.1520318557; __utmc=74692624; __utmz=74692624.1520318557.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); mp_mixpanel__c=1")
				.host("www.supremenewyork.com")
				.connection("keep-alive")
				.accept("*/*;q=0.5, text/javascript, application/javascript, application/ecmascript, application/x-ecmascript")
				.other("Origin", "http://www.supremenewyork.com")
				.other("X-CSRF-Token", "uoMrwBfdjoUoSUTeBPAPLdX0HwDmE1I+0gD0pcuv5LkSKy3EvOkYkDMT3Kuwvxd8Xlf405vajGSapLiVEyCWLw==")
				.other("X-Requested-With", " XMLHttpRequest")
				.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36")
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.referer("http://www.supremenewyork.com/shop/accessories/jz9ugd3mp/yybt603d8")
				.acceptEncoding("gzip, deflate")
				.acceptLanguage("zh-CN,zh;q=0.8")
				.build();

		HCB hcb = null;
		try {
			hcb = HCB.custom().timeout(10000).pool(100, 10).retry(5).proxy("127.0.0.1", 8888);
		} catch (HttpProcessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpClient client = hcb.build();
		
		// 瓒呮椂
		// 鍚敤杩炴帴姹狅紝姣忎釜璺敱鏈�澶у垱寤�10涓摼鎺ワ紝鎬昏繛鎺ユ暟闄愬埗涓�100涓�
		// https锛屾敮鎸佽嚜瀹氫箟ssl璇佷功璺緞鍜屽瘑鐮侊紝ssl(String keyStorePath, String keyStorepass)
		// 閲嶈瘯5娆�

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("utf8", "✓");
		map.put("st", "18393");
		map.put("s", "50881");
		map.put("commit", "add to cart");
		HttpConfig config = HttpConfig.custom().url("http://www.supremenewyork.com/shop/171219/add").map(map)
				.client(client).encoding("utf-8").headers(headers);
		String result2 = "";
		try {
			result2 = HttpClientUtil.post(config);
		} catch (HttpProcessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // post璇锋眰
		System.out.print(result2);
		return "showStudentInfo";
	}
}
