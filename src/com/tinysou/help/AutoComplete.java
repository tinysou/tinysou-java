package com.tinysou.help;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class AutoComplete {

	protected String authToken = new String();
	protected String engineName = new String();
	protected String collectionName = new String();
	protected Map<String, String> header = new HashMap<String, String>();
	protected String paramsBody = new String();
	protected JSONObject json = new JSONObject();
	protected List<Object> result = new ArrayList<Object>();

	public AutoComplete(String authToken, String engineName,
			String collectionName) {
		this.authToken = authToken;
		this.engineName = engineName;
		this.collectionName = collectionName;
	}

	public void setParams(JSONObject paramsBody) {
		this.paramsBody = paramsBody.toString();
	}

	public List<Object> doAutoCompleteSingleCollection() throws Exception {
		String token = "token " + authToken;
		header.put("Authorization", token);
		header.put("Content-Type", "application/json");
		String url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/collections/" + collectionName + "/autocomplete";
		TinySouClient client = new TinySouClient(url, "POST", header,
				paramsBody);
		String response = client.execute();
		json = new JSONObject(response);
		int statusCode = client.getStatusCode();
		result.add(json);
		result.add(statusCode);
		return result;
	}

	public List<Object> doAutoCompleteMultiCollection() throws Exception {
		String token = "token " + authToken;
		header.put("Authorization", token);
		header.put("Content-Type", "application/json");
		String url = "http://api.tinysou.com/v1/engines/" + engineName
				+ "/autocomplete";
		TinySouClient client = new TinySouClient(url, "POST", header,
				paramsBody);
		String response = client.execute();
		json = new JSONObject(response);
		int statusCode = client.getStatusCode();
		result.add(json);
		result.add(statusCode);
		return result;
	}
}
