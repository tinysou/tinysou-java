package com.tinysou.help;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class Collection {

	protected String AUTH_TOKEN = new String();
	protected String engineName = new String();
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

	public Collection(String AUTH_TOKEN, String engineName) {
		this.AUTH_TOKEN = AUTH_TOKEN;
		this.engineName = engineName;
		// 设置header
		String token = "token " + AUTH_TOKEN;
		header.put("Authorization", token);
	}

	// 罗列 Collections
	public List<Object> list() throws Exception {
		url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections";
		method = "GET";
		statusOk = 200;
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		jsonTokener = new JSONTokener(response);
		int statusCode = client.getStatusCode();
		result.add(response);
		result.add(statusCode);
		return result;
	}

	// 创建一个 Collection
	public List<Object> create(String collectionName,
			Map<String, String> field_types) throws Exception {
		url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections";
		method = "POST";
		statusOk = 201;
		// 设置params
		JSONObject params = new JSONObject();
		params.accumulate("name", collectionName);
		params.accumulate("field_types", field_types);
		paramsBody = params.toString();
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		json = new JSONObject(response);
		int statusCode = client.getStatusCode();
		result.add(response);
		result.add(statusCode);
		return result;
	}

	// 获取一个 Collection
	public List<Object> get(String collectionName) throws Exception {
		url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections/" + collectionName;
		method = "GET";
		statusOk = 200;
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		json = new JSONObject(response);
		int statusCode = client.getStatusCode();
		result.add(response);
		result.add(statusCode);
		return result;
	}

	// 删除一个 Collection
	public List<Object> delete(String collectionName) throws Exception {
		url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections/" + collectionName;
		method = "DELETE";
		statusOk = 204;
		TinySouClient client = new TinySouClient(url, method, header,
				paramsBody);
		response = client.execute();
		json = new JSONObject();
		int statusCode = client.getStatusCode();
		result.add(response);
		result.add(statusCode);
		return result;
	}

}
