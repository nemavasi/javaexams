package javaexams.js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TstJs2 {
  public static void main(String[] args) throws Exception {

    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");

    // JavaScript code in a String
    String script1 = "function transform(urlParameters, exportAnswer) {"
        + "var obj = new Object(); "
        + "var rec = {'k' : 'IMPORT_ID', 'v' : urlParameters.replace(/id=/, '')};"
        + "obj.urlData = [rec];"
        + "var rec = {'k' : 'IMPORT_BODY', 'v' : exportAnswer};"
        + "obj.bodyData = [rec];"
        + "return JSON.stringify(obj);"
        + "}";

    engine.eval(script1);

    Invocable inv = (Invocable) engine;
    System.out.println(inv.invokeFunction("transform", "id=12345", "sdfsdf sdfsdf ; asdasdasd asd"));


    String script2 = "function transform(exportAnswer) {"
        + "var obj = new Object(); "
        + "var ans = JSON.parse(exportAnswer); "
        + "obj.records = [];"
        + "var arr = ans.records[0]; "
        + "return JSON.stringify(arr);"
        + "}";
//        + "var index; "
//        + "for (index = 0; index < arr.length; ++index) {"
//        + "  var rec = {'k' : arr[index].fieldId, 'v' : arr[index].value};"
//        + "  obj.records.push(rec);"
//        + "}"
//        + "return JSON.stringify(obj);"
//        + "}";

    engine.eval(script2);

    Invocable inv2 = (Invocable) engine;
    System.out.println(inv2.invokeFunction("transform", "{\n" +
        "    \"records\": [\n" +
        "    {\n" +
        "    \"mode\": \"create\",\n" +
        "    \"fields\": [\n" +
        "{\"fieldId\": \"COUNTRY\", \"value\": \"Europe\"},\n" +
        "                                                 {\"fieldId\": \"CITY\", \"value\": \"London\"}" +
        "    ]\n" +
        "    }\n" +
        "    ]\n" +
        "    }"));

  }
}

//{
//    "urlData": [
//    {"k" : "COUNTRY" , "v" : "Europe" },
//    {"k" : "CITY" , "v" : "London" }
//    ],
//    "bodyData": [
//    {"k" : "BODY" , "v" : null }
//    ]
//    }


//{
//    "records": [
//    {
//    "mode": "create",
//    "fields": [
//    {"fieldId": "last_name", "value": "Тестовый"},
//    {"fieldId": "first_name", "value": "Домон"}
//    ]
//    }
//    ]
//    }

//  var index;
//for (index = 0; index < a.length; ++index) {
//    console.log(a[index]);
//    }