import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.tinysou.help.Collection;
import com.tinysou.help.Engine;
import com.tinysou.help.Document;
import com.tinysou.help.Search;

public class Demo {

	/**
	 * @param args
	 * @throws Exception
	 */

	public final static String AUTH_TOKEN = "fc0e0c3eedab24673c4e";
	public final static String ENGINE_NEME = "wym";
	public static List<Object> result = new ArrayList<Object>();
	protected static JSONObject json = new JSONObject();
	protected static JSONTokener jsonTokener = new JSONTokener(new String());
	public static int statusCode;

	public static void main(String[] args) throws Exception {
		// EngineTest();
		// CollectionTest();
		// DocumentTest();
		SearchTest();
	}

	/*
	 * engine Api ，演示如下操作： 罗列 Engines 创建一个 Engine 获取一个 Engine 更新一个 Engine 删除一个
	 * Engine
	 */
	public static void EngineTest() throws Exception {
		// 新建engine
		Engine engine = new Engine(AUTH_TOKEN);
		// 罗列 Engines
		result = engine.list();
		result.clear();
		// 创建Engine
		result = engine.create(ENGINE_NEME, "hetun");
		result.clear();
		// 获取Engine
		result = engine.get(ENGINE_NEME);
		System.out.println("response " + result.get(0) + " statusCode "
				+ result.get(1));
		result.clear();
		// 更新Engine
		result = engine.update(ENGINE_NEME, "panghetun");
		result.clear();
		// 删除Engine
		result = engine.delete(ENGINE_NEME);
	}

	/*
	 * Collection Api ，演示如下操作： 罗列 Collections 创建一个 Collection 获取一个 Collection
	 * 更新一个 Collection 删除一个 Collection
	 */
	public static void CollectionTest() throws Exception {
		// 新建Collection
		Collection collection = new Collection(AUTH_TOKEN, ENGINE_NEME);
		Map<String, String> field_types = new HashMap<String, String>();
		field_types.put("title", "string");
		field_types.put("tags", "string");
		field_types.put("author", "enum");
		field_types.put("date", "date");
		field_types.put("body", "text");
		// 创建名为"collectionName"的Collection
		result = collection.create("collectionName", field_types);
		result.clear();
		// 罗列 Collections
		result = collection.list();
		result.clear();
		// 获取名为"collectionName"的Collection
		result = collection.get("collectionName");
		result.clear();
		// 删除名为"collectionName"的Collection
		result = collection.delete("collectionName");
	}

	/*
	 * Document Api ，演示如下操作： 罗列 Documents 创建一个 Document 获取一个 Document 更新一个
	 * Document 删除一个 Document
	 */
	public static void DocumentTest() throws Exception {
		// 新建Document
		Document document = new Document(AUTH_TOKEN, "engineName",
				"collectionName");
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
		// 创建一个Document
		result = document.create(field_types);
		statusCode = new Integer(result.get(1).toString());
		String documentId = new String();
		// 判断响应是否正常
		if (statusCode == 201) {
			json = (JSONObject) result.get(0);
			// 获取新建的document的id
			documentId = json.getString("id");
		} else {
			return;
		}
		result.clear();
		result = document.list();
		result.clear();
		// 获取Document
		result = document.get(documentId);
		result.clear();
		// 更新Document
		result = document.update(documentId, field_types);
		result.clear();
		// 删除Document
		result = document.delete(documentId);
	}
	
	public static void SearchTest() throws Exception{
		Search search = new Search(AUTH_TOKEN, ENGINE_NEME, "page");
		JSONObject paramsBody = new JSONObject();
		paramsBody.put("q", "搜索");
		paramsBody.put("c", "page");
		search.setParams(paramsBody);
		result = search.doSearch();
		System.out.println("response " + result.get(0) + " statusCode "
				+ result.get(1));
	}
}
