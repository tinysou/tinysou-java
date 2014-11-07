package com.tinysou.help;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Test {

	/**
	 * @param args
	 * @throws Exception
	 */

	public final static String AUTH_TOKEN = "fc0e0c3eedab24673c4e";
	public static List<Object> result = new ArrayList<Object>();
	protected static JSONObject json = new JSONObject();
	protected static JSONTokener jsonTokener = new JSONTokener(new String());
	public static int statusCode;

	public static void main(String[] args) throws Exception {
		 EngineTest();
		// CollectionTest();
		//Document();
	}

	public static void EngineTest() throws Exception {
		Engine engine = new Engine(AUTH_TOKEN);
		result = engine.list();
		System.out.println("repsonse " + result.get(0) + " statusCode "
				+ result.get(1));
		result.clear();
		result = engine.create("wym2", "");
		System.out.println("repsonse " + result.get(0) + " statusCode "
				+ result.get(1));
		result.clear();
		result = engine.get("wym2");
		System.out.println("repsonse " + result.get(0) + " statusCode "
				+ result.get(1));
		result.clear();
		result = engine.update("wym2", "");
		System.out.println("repsonse " + result.get(0) + " statusCode "
				+ result.get(1));
		result.clear();
		result = engine.delete("wym2");
		System.out.println("repsonse " + result.get(0) + " statusCode "
				+ result.get(1));
	}

	public static void CollectionTest() throws Exception {
		Collection collection = new Collection(AUTH_TOKEN, "wym2");
		Map<String, String> field_types = new HashMap<String, String>();
		field_types.put("title", "string");
		field_types.put("tags", "string");
		field_types.put("author", "enum");
		field_types.put("date", "date");
		field_types.put("body", "text");
		result = collection.create("collectionName", field_types);
		System.out.println("repsonse " + result.get(0) + " statusCode "
				+ result.get(1));
		result.clear();
		result = collection.list();
		System.out.println("repsonse " + result.get(0) + " statusCode "
				+ result.get(1));
		result.clear();
		result = collection.get("collectionName");
		System.out.println("repsonse " + result.get(0) + " statusCode "
				+ result.get(1));
		result.clear();
		result = collection.delete("collectionName");
		System.out.println("repsonse " + result.get(0) + " statusCode "
				+ result.get(1));
		result = collection.create("collectionName", field_types);
	}

	public static void Document() throws Exception {
		Document document = new Document(AUTH_TOKEN, "wym2", "collectionName");
		Map<String, Object> field_types = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(sdf.format(new Date()));
		field_types.put("title", "支持拼音搜索");
		field_types.put("tags", "[\"公告\", \"特性\"]");
		field_types.put("author", "Michael Ding");
		field_types.put("date", date);
		field_types
				.put("body",
						"我们很高兴地在这里宣布，今天开始，微搜索支持拼音搜索了。微搜索的拼音搜索包括：拼音补全，首字母搜索及补全，例如：如果你的文本中包含 程序员，输入 cxy, chen, chengxu均可匹配到程序员效果如下图所示：");
		result = document.create(field_types);
		System.out.println("repsonse " + result.get(0) + " statusCode "
				+ result.get(1));
		statusCode = new Integer(result.get(1).toString());
		if (statusCode == 201) {
			json = (JSONObject) result.get(0);
		}
		String documentId = json.getString("id");
		System.out.println(json.getString("id"));
		result.clear();
		result = document.list();
		System.out.println("repsonse " + result.get(0) + " statusCode "
				+ result.get(1));
		result.clear();
		result = document.get(documentId);
		System.out.println("repsonse " + result.get(0) + " statusCode "
				+ result.get(1));
		result.clear();
		result = document.update(documentId, field_types);
		System.out.println("repsonse " + result.get(0) + " statusCode "
				+ result.get(1));
		result.clear();
		result = document.delete(documentId);
		System.out.println("repsonse " + result.get(0) + " statusCode "
				+ result.get(1));
	}
}
