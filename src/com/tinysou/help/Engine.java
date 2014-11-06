package com.tinysou.help;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

import com.tinysou.help.HttpHelp;

public class Engine {

	protected String AUTH_TOKEN = new String();
	protected String url = new String();
	protected Map<String, String> header = new HashMap<String, String>();
	protected HttpHelp request = new HttpHelp();
	protected String method = new String();
	protected String paramsBody = new String();
	protected int statusOk;
	protected String response = new String();
	protected List<Object> result = new ArrayList<Object>();

	public Engine(String AUTH_TOKEN) {
		this.AUTH_TOKEN = AUTH_TOKEN;
		// 设置header
		String token = "token " + AUTH_TOKEN;
		header.put("Authorization", token);
	}

	// 罗列 Engines
	public List<Object> list() throws Exception {
		url = "http://api.tinysou.com/v1/engines";
		method = "GET";
		statusOk = 200;
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		int statusCode = client.getStatusCode();
		result.add(response);
		result.add(statusCode);
		return result;

	}

	// 创建一个 Engine
	public List<Object> create(String engineName, String displayName)
			throws Exception {
		url = "http://api.tinysou.com/v1/engines";
		method = "POST";
		statusOk = 201;
		// 设置params
		JSONObject params = new JSONObject();
		params.accumulate("name", engineName);
		if (!("".equals(displayName))) {
			params.accumulate("display_name", displayName);
		}
		paramsBody = params.toString();
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		int statusCode = client.getStatusCode();
		result.add(response);
		result.add(statusCode);
		return result;
	}

	// 获取一个 Engine
	public List<Object> get(String engineName) throws Exception {
		url = "http://api.tinysou.com/v1/engines/" + engineName;
		method = "GET";
		statusOk = 200;
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		int statusCode = client.getStatusCode();
		result.add(response);
		result.add(statusCode);
		return result;
	}

	// 更新一个 Engine
	public List<Object> update(String engineName, String displayName)
			throws Exception {
		url = "http://api.tinysou.com/v1/engines/" + engineName;
		method = "PUT";
		statusOk = 200;
		// 设置params
		JSONObject params = new JSONObject();
		params.accumulate("display_name", displayName);
		paramsBody = params.toString();
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		int statusCode = client.getStatusCode();
		result.add(response);
		result.add(statusCode);
		return result;
	}

	// 删除一个 Engine
	public List<Object> delete(String engineName) throws Exception {
		url = "http://api.tinysou.com/v1/engines/" + engineName;
		method = "DELETE";
		statusOk = 204;
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		int statusCode = client.getStatusCode();
		result.add(response);
		result.add(statusCode);
		return result;
	}
}
