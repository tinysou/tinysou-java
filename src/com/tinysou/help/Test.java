package com.tinysou.help;

import java.util.ArrayList;
import java.util.List;

public class Test {

	/**
	 * @param args
	 * @throws Exception
	 */

	public final static String AUTH_TOKEN = "fc0e0c3eedab24673c4e";
	public static List<Object> result = new ArrayList<Object>();
	public String response = new String();
	public int statusCode;

	public static void main(String[] args) throws Exception {
		EngineTest();
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
}
