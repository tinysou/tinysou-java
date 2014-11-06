package com.tinysou.help;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import com.tinysou.help.HttpHelp;

public class Engine{

    protected String token = new String();
    protected String url = new String();
    protected Map<String, String> header = new HashMap<String, String>();
    protected HttpHelp request = new HttpHelp();
    protected String method = new String();
    protected String paramsBody = new String();
    protected Header Header;

    public Engine(){}

    //罗列 Engines
    public void list(){
        url = "http://api.tinysou.com/v1/engines";
        method = "GET";
    }

    //创建一个 Engine
    public void create(String name, Map<String, String> field_types){
        url = "http://api.tinysou.com/v1/engines";
        method = "POST";
    }

    //获取一个 Engine
    public void get(String name){
        url = "http://api.tinysou.com/v1/engines/" + name;
        method = "GET";
    }

    //更新一个 Engine
    public void update(String name, String display_name){
        url = "http://api.tinysou.com/v1/engines/" + name;
        method = "PUT";
    }

    //删除一个 Engine
    public void delete(String name){
        url = "http://api.tinysou.com/v1/engines/"+name;
        method = "DELETE";
    }
}
