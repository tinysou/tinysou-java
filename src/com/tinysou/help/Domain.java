package com.tinysou.help;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Domain {

	protected String AUTH_TOKEN = new String();
	protected String engineName = new String();
	protected String url = new String();
	protected Map<String, String> header = new HashMap<String, String>();
	protected HttpHelp request = new HttpHelp();
	protected String method = new String();
	protected String paramsBody = new String();
	protected int statusOk;

	public Domain(String AUTH_TOKEN, String engineName) {
		this.AUTH_TOKEN = AUTH_TOKEN;
		this.engineName = engineName;
		// 设置header
		String token = "token " + AUTH_TOKEN;
		header.put("Authorization", token);
	}

	// 罗列 Domains
	public void list() {
		url = "http://api.tinysou.com/v1/engines/" + engineName;
		method = "GET";
		statusOk = 200;
		TinySouClient client = new TinySouClient(url, method, header, paramsBody);
	}

	// 创建一个 Domain
	public void create(String url, JSONArray whiteList, JSONArray blackList)
			throws JSONException {
		url = "http://api.tinysou.com/v1/engines/" + engineName;
		method = "POST";
		statusOk = 201;
		// 设置params
		JSONObject params = new JSONObject();
		params.accumulate("url", url);
		params.accumulate("white_list", whiteList);
		params.accumulate("black_list", blackList);
		paramsBody = params.toString();
		TinySouClient client = new TinySouClient(url, method, header, paramsBody);
	}

	// 获取一个 Domain
	public void get(String domainId) {
		url = "http://api.tinysou.com/v1/engines/" + engineName + "domains/" + domainId;
		method = "GET";
		statusOk = 200;
		TinySouClient client = new TinySouClient(url, method, header, paramsBody);
	}

	// 更新一个 Domain
	public void update(String domainId, String url, List<String> whiteList, List<String> blackList)
			throws JSONException {
		url = "http://api.tinysou.com/v1/engines/" + engineName + "domains/" + domainId;
		method = "PUT";
		statusOk = 200;
		// 设置params
		JSONObject params = new JSONObject();
		params.accumulate("url", url);
		params.accumulate("white_list", whiteList);
		params.accumulate("black_list", blackList);
		paramsBody = params.toString();
		TinySouClient client = new TinySouClient(url, method, header, paramsBody);
	}

	// 删除一个 Domain
	public void delete(String domainId) {
		url = "http://api.tinysou.com/v1/engines/" + engineName + "domains/" + domainId;
		method = "DELETE";
		statusOk = 204;
		TinySouClient client = new TinySouClient(url, method, header, paramsBody);
	}

}
