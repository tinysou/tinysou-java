package com.tinysou.help;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class Document {

	protected String AUTH_TOKEN = new String();
	protected String engineName = new String();
	protected String collectionName = new String();
	protected String url = new String();
	protected Map<String, String> header = new HashMap<String, String>();
	protected HttpHelp request = new HttpHelp();
	protected String method = new String();
	protected String paramsBody = new String();
	protected int statusOk;

	public Document(String AUTH_TOKEN, String engineName, String collectionName) {
		this.AUTH_TOKEN = AUTH_TOKEN;
		this.engineName = engineName;
		this.collectionName = collectionName;
		// 设置header
		String token = "token " + AUTH_TOKEN;
		header.put("Authorization", token);
	}

	// 罗列 Documents
	public void list() {
		url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections" + collectionName + "/documents";
		method = "GET";
		statusOk = 200;
		TinySouClient client = new TinySouClient(url, method, header, paramsBody);
	}

	// 创建一个 Document
	public void create(Map<String, String> field_types) throws JSONException {
		url = "http://api.tinysou.com/v1/engines" + engineName + "/collections"
				+ collectionName + "/documents";
		method = "POST";
		statusOk = 201;
		// 设置params
		JSONObject params = new JSONObject();
		for (String key : field_types.keySet()) {
			params.accumulate(key, field_types.get(key));
		}
		paramsBody = params.toString();
		TinySouClient client = new TinySouClient(url, method, header, paramsBody);
	}

	// 获取一个 Document
	public void get(String documentId) {
		url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections" + collectionName + "/document_id" + documentId;
		method = "GET";
		statusOk = 200;
		TinySouClient client = new TinySouClient(url, method, header, paramsBody);
	}

	// 更新一个 Document
	public void update(String documentId, Map<String, String> field_types)
			throws JSONException {
		url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections" + collectionName + "/document_id" + documentId;
		method = "PUT";
		statusOk = 200;// 创建201
		// 设置params
		JSONObject params = new JSONObject();
		for (String key : field_types.keySet()) {
			params.accumulate(key, field_types.get(key));
		}
		paramsBody = params.toString();
		TinySouClient client = new TinySouClient(url, method, header, paramsBody);
	}

	// 删除一个 Document
	public void delete(String documentId) {
		url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections" + collectionName + "/document_id" + documentId;
		method = "DELETE";
		statusOk = 204;
		TinySouClient client = new TinySouClient(url, method, header, paramsBody);
	}

}
