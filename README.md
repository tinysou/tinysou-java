# tinysou-java

Tinysou Java client

## Installation

Download [tinysou-java-v1.00.jar](https://github.com/wangyeming/tinysou-java/tree/develop/jar) and import to your java project as a library

## Usage

```java
 import com.tinysou.help.Collection;
 import com.tinysou.help.Engine;
 import com.tinysou.help.Document;
```

## Engine
```java
 Engine engine = new Engine(AUTH_TOKEN);
 
```
List:
```java
 engine.list();
```

Create:
```java
 engine.create(ENGINE_NEME, DISPLAY_NAME);
```

Get:
```java
 engine.get(ENGINE_NEME);
```

Update:
```java
 engine.update(ENGINE_NEME,DISPLAY_NAME);
```

Delete:
```java
 engine.delete(ENGINE_NEME);
```

## Collection

```java
 Collection collection = new Collection(AUTH_TOKEN, ENGINE_NEME);
```

List:
```java
 collection.list();
```

Create:
```java
 collection.create(COLLECTION_NAME, field_types);
```

Get:
```java
 collection.get(COLLECTION_NAME);
```

Delete:
```java
 collection.delete(COLLECTION_NAME);
```

## Document

```java
 Document document = new Document(AUTH_TOKEN, ENGINE_NEME, COLLECTION_NAME);
 
```
List:
```java
 document.list();
```

Create:
```java
 document.create(field_types);
```

Get:
```java
 document.get(documentId);
```

Update:
```java
 document.update(documentId,field_types);
```

Delete:
```java
 document.delete(documentId);
```

## Search
```java
 Search search = new Search(AUTH_TOKEN, ENGINE_NEME, "page");
 JSONObject paramsBody = new JSONObject();
	paramsBody.put("q", "搜索");
 search.setParams(paramsBody);
 search.doSearchSingleCollection();  //单collection搜索
 paramsBody.put("c", "page1,page2");
 search.doSearchMultiCollection();  //跨collection搜索
```

## Autocomplete
```java
  AutoComplete autoComplete = new AutoComplete(AUTH_TOKEN, ENGINE_NEME, "page");
  JSONObject paramsBody = new JSONObject();
  paramsBody.put("q", "搜索");
  autoComplete.setParams(paramsBody);
  autoComplete.doAutoCompleteSingleCollection();  //单collection自动补全
  paramsBody.put("c", "page1,page2");
  autoComplete.doAutoCompleteMultiCollection();  //跨collection自动补全
```

## Examples
See [examples](https://github.com/wangyeming/tinysou-java/tree/develop/examples)

## Contributing
1. Fork it ( https://github.com/tinysou/tinysou-java/fork )
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -am 'Add some feature')
4. Push to the branch (git push origin my-new-feature)
5. Create a new Pull Request
