package com.tinysou.help;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class Collection {

	protected String AUTH_TOKEN = new String();
	protected String engineName = new String();
	protected String url = new String();
	protected Map<String, String> header = new HashMap<String, String>();
	protected HttpHelp request = new HttpHelp();
	protected String method = new String();
	protected String paramsBody = new String();
	protected int statusOk;

	public Collection(String AUTH_TOKEN, String engineName) {
		this.AUTH_TOKEN = AUTH_TOKEN;
		this.engineName = engineName;
		// 设置header
		String token = "token " + AUTH_TOKEN;
		header.put("Authorization", token);
	}

	// 罗列 Collections
	public void list() {
		url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections";
		method = "GET";
		statusOk = 200;
		TinySouClient client = new TinySouClient(url, method, header, paramsBody);
	}

	// 创建一个 Collection
	public void create(String collectionName, Map<String, String> field_types)
			throws JSONException {
		url = "http://api.tinysou.com/v1/engines" + engineName + "/collections";
		method = "POST";
		statusOk = 201;
		// 设置params
		JSONObject params = new JSONObject();
		params.accumulate("name", collectionName);
		params.accumulate("field_types", field_types);
		paramsBody = params.toString();
		TinySouClient client = new TinySouClient(url, method, header, paramsBody);
	}

	// 获取一个 Collection
	public void get(String collectionName) {
		url = "http://api.tinysou.com/v1/engines/" + collectionName
				+ "/collections" + collectionName;
		method = "GET";
		statusOk = 200;
		TinySouClient client = new TinySouClient(url, method, header, paramsBody);
	}

	// 删除一个 Collection
	public void delete(String collectionName) {
		url = "http://api.tinysou.com/v1/engines/" + collectionName
				+ "/collections" + collectionName;
		method = "DELETE";
		statusOk = 204;
		TinySouClient client = new TinySouClient(url, method, header, paramsBody);
	}

}
