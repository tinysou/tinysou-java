package com.tinysou.help;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.tinysou.help.HttpHelp;

public class Engine {

	protected String AUTH_TOKEN = new String();
	protected String baseUrl = "http://api.tinysou.com/v1/engines/";
	protected String url;
	protected Map<String, String> header = new HashMap<String, String>();
	protected HttpHelp request = new HttpHelp();
	protected String method = new String();
	protected String paramsBody = new String();
	protected int statusOk;
	protected String response = new String();
	protected JSONObject json = new JSONObject();
	protected JSONTokener jsonTokener = new JSONTokener(new String());
	protected List<Object> result = new ArrayList<Object>();

	public Engine(String AUTH_TOKEN) {
		this.AUTH_TOKEN = AUTH_TOKEN;
		// 设置header
		String token = "token " + AUTH_TOKEN;
		header.put("Authorization", token);
	}

	// 罗列 Engines
	public List<Object> list() throws Exception {
		url = baseUrl;
		method = "GET";
		statusOk = 200;
		getResult(true);
		return result;

	}

	// 创建一个 Engine
	public List<Object> create(String engineName, String displayName)
			throws Exception {
		url = baseUrl;
		method = "POST";
		statusOk = 201;
		// 设置params
		JSONObject params = new JSONObject();
		params.accumulate("name", engineName);
		if (!("".equals(displayName))) {
			params.accumulate("display_name", displayName);
		}
		paramsBody = params.toString();
		getResult(false);
		return result;
	}

	// 获取一个 Engine
	public List<Object> get(String engineName) throws Exception {
		url = baseUrl + engineName;
		method = "GET";
		statusOk = 200;
		getResult(false);
		return result;
	}

	// 更新一个 Engine
	public List<Object> update(String engineName, String displayName)
			throws Exception {
		url = baseUrl + engineName;
		method = "PUT";
		statusOk = 200;
		// 设置params
		JSONObject params = new JSONObject();
		params.accumulate("display_name", displayName);
		paramsBody = params.toString();
		getResult(false);
		return result;
	}

	// 删除一个 Engine
	public List<Object> delete(String engineName) throws Exception {
		url = baseUrl + engineName;
		method = "DELETE";
		statusOk = 204;
		getResult(true);
		return result;
	}

	// 建立微搜索请求，获取响应结果
	public void getResult(boolean isToken) throws Exception {
		result.clear();
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		if (isToken) {
			jsonTokener = new JSONTokener(response);
		} else {
			json = new JSONObject(response);
		}
		int statusCode = client.getStatusCode();
		result.add(response);
		result.add(statusCode);
	}
}
