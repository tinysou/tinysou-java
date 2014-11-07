package com.tinysou.help;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

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
	protected String response = new String();
	protected JSONObject json = new JSONObject();
	protected JSONTokener jsonTokener = new JSONTokener(new String());
	protected List<Object> result = new ArrayList<Object>();

	public Document(String AUTH_TOKEN, String engineName, String collectionName) {
		this.AUTH_TOKEN = AUTH_TOKEN;
		this.engineName = engineName;
		this.collectionName = collectionName;
		// 设置header
		String token = "token " + AUTH_TOKEN;
		header.put("Authorization", token);
	}

	// 罗列 Documents
	public List<Object> list() throws Exception {
		url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections/" + collectionName + "/documents";
		method = "GET";
		statusOk = 200;
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		jsonTokener = new JSONTokener(response);
		int statusCode = client.getStatusCode();
		result.add(json);
		result.add(statusCode);
		return result;
	}

	// 创建一个 Document
	public List<Object> create(Map<String, Object> field_types)
			throws Exception {
		url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections/" + collectionName + "/documents";
		method = "POST";
		statusOk = 201;
		// 设置params
		JSONObject params = new JSONObject();
		for (String key : field_types.keySet()) {
			params.accumulate(key, field_types.get(key));
		}
		paramsBody = params.toString();
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		json = new JSONObject(response);
		int statusCode = client.getStatusCode();
		result.add(json);
		result.add(statusCode);
		return result;
	}

	// 获取一个 Document
	public List<Object> get(String documentId) throws Exception {
		url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections/" + collectionName + "/documents/" + documentId;
		method = "GET";
		statusOk = 200;
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		json = new JSONObject(response);
		int statusCode = client.getStatusCode();
		result.add(json);
		result.add(statusCode);
		return result;
	}

	// 更新一个 Document
	public List<Object> update(String documentId,
			Map<String, Object> field_types) throws Exception {
		url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections/" + collectionName + "/documents/" + documentId;
		method = "PUT";
		statusOk = 200;// 创建201
		// 设置params
		JSONObject params = new JSONObject();
		for (String key : field_types.keySet()) {
			params.accumulate(key, field_types.get(key));
		}
		paramsBody = params.toString();
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		json = new JSONObject(response);
		int statusCode = client.getStatusCode();
		result.add(json);
		result.add(statusCode);
		return result;
	}

	// 删除一个 Document
	public List<Object> delete(String documentId) throws Exception {
		url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections/" + collectionName + "/documents/" + documentId;
		method = "DELETE";
		statusOk = 204;
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		json = new JSONObject();
		int statusCode = client.getStatusCode();
		result.add(json);
		result.add(statusCode);
		return result;
	}

}
