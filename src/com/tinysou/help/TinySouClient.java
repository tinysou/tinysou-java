package com.tinysou.help;

import java.util.Map;

import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;

import com.tinysou.help.HttpHelp;

public class TinySouClient {

	protected String url;
	protected String method;
	protected Map<String, String> header;
	protected String paramsBody;
	protected int statusCode;

	public TinySouClient(String url, String method, Map<String, String> header,
			String paramsBody) {
		this.url = url;
		this.method = method;
		this.header = header;
		this.paramsBody = paramsBody;
	}

	// 建立Request--设置header，params
	public HttpHelp buildRequest() {
		System.out.println("AAAAAAA");
		HttpHelp httpRequest = new HttpHelp();
		httpRequest.setCharset(HTTP.UTF_8).setConnectedTimeout(5000)
				.setSoTimeout(10000);
		httpRequest
				.setOnHttpRequestListener(new HttpHelp.OnHttpRequestListener() {
					@Override
					public void onRequest(HttpHelp request) throws Exception {
						System.out.println("BBBBBBB");
						for (String key : header.keySet()) {
							request.addHeader(key, header.get(key));
							System.out.println("key "+key+" value "+ header.get(key));
						}
						StringEntity entity = new StringEntity(paramsBody,
								HTTP.UTF_8);
						System.out.println("paramsBody "+paramsBody);
						request.buildRequestEntity(method, entity);
					}

					@Override
					public String onSucceed(int statusCode, HttpHelp request)
							throws Exception {
						return request.getInputStreamJson();
					}

					@Override
					public String onFailed(int statusCode, HttpHelp request)
							throws Exception {
						return "POST请求失败：statusCode " + statusCode;
					}
				});
		return httpRequest;
	}

	public String execute() throws Exception {
		System.out.println("aaaaaaa");
		HttpHelp request = this.buildRequest();
		System.out.println("bbbbbbb");
		String result;
		if ("GET".equals(method)) {
			System.out.println("ccccccc");
			result = request.get(url);
			System.out.println("dddddd");
		} else if ("POST".equals(method)) {
			result = request.post(url);
		} else if ("PUT".equals(method)) {
			result = request.put(url);
		} else if ("DELETE".equals(method)) {
			result = request.delete(url);
		} else {
			result = "方法异常";
		}
		System.out.println("eeeeeeee");
		statusCode = request.getStatusCode();
		System.out.println("fffffff");
		return result;
	}

	public int getStatusCode() {
		return statusCode;
	}
}
