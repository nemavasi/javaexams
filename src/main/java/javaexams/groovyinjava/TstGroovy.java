package javaexams.groovyinjava;

import groovy.util.Eval;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TstGroovy {
  public static void main(String[] args) {
    String result = Eval.me("def language = 'Groovy'; \"Hello from $language\";").toString();
    System.out.println(result);

    final Map values = new HashMap();
    values.put("name", "mrhaki");
    values.put("lang", "Groovy");
    String expression = "\"Hello $params.name from $params.lang\"";
    result = Eval.me("params", values, expression).toString();
    System.out.println(result);


    final Map datas = new HashMap();
    datas.put("pocket", "{\"id\":\"123\", \"value\":15.6 }");
    String code =
          "class Account {\n" +
        "\t    String id\n" +
        "\t    BigDecimal value\n" +
        "\t    Date createdAt\n" +
        "\t}\n" +
        "groovy.json.JsonGenerator generator = new groovy.json.JsonGenerator.Options()\n" +
        "\t  .dateFormat('MM/dd/yyyy')\n" +
        "\t  .excludeFieldsByName('value')\n" +
        "\t  .build()\n" +
        "def jsonSlurper = new groovy.json.JsonSlurper()\n" +
                  "def account = jsonSlurper.parseText(params.pocket) as Account\n" +
                  "groovy.json.JsonOutput.prettyPrint(generator.toJson(account))"
                  ;
    result = Eval.me("params", datas, code).toString();
    System.out.println(result);

//    class Account {
//        String id;
//        float value;
//        Date createdAt;
//        }
//    ;

  }
}
