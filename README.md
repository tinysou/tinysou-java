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
```
 Engine engine = new Engine(AUTH_TOKEN);
 
```
List:
```
 engine.list();
```

Create:
```
 engine.create(ENGINE_NEME, DISPLAY_NAME);
```

Get:
```
 engine.get(ENGINE_NEME);
```

Update:
```
 engine.update(ENGINE_NEME,DISPLAY_NAME);
```

Delete:
```
 engine.delete(ENGINE_NEME);
```

## Collection

```
 Collection collection = new Collection(AUTH_TOKEN, ENGINE_NEME);
```

List:
```
 collection.list();
```

Create:
```
 collection.create(COLLECTION_NAME, field_types);
```

Get:
```
 collection.get(COLLECTION_NAME);
```

Delete:
```
 collection.delete(COLLECTION_NAME);
```

## Document

```
 Document document = new Document(AUTH_TOKEN, ENGINE_NEME, COLLECTION_NAME);
 
```
List:
```
 document.list();
```

Create:
```
 document.create(field_types);
```

Get:
```
 document.get(documentId);
```

Update:
```
 document.update(documentId,field_types);
```

Delete:
```
 document.delete(documentId);
```

## Search

## Autocomplete

## Examples
See [examples](https://github.com/wangyeming/tinysou-java/tree/develop/examples)

## Contributing
1. Fork it ( https://github.com/tinysou/tinysou-java/fork )
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -am 'Add some feature')
4. Push to the branch (git push origin my-new-feature)
5. Create a new Pull Request
