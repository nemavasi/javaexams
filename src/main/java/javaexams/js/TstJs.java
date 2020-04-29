package javaexams.js;

import javax.script.*;

public class TstJs {
  public static void main(String[] args) throws Exception {

    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");

    // JavaScript code in a String
    String script1 = (String) "function hello(name) {print ('Hello, ' + name);}";
    String script2 = (String) "function getValue(a,b) { if (a===\"Number\") return 1; else return b; }";
    String script3 = (String) "function foo(a) { if (a===\"Number\") return 1; else return 2; }";
    engine.eval(script1);
    engine.eval(script2);
    engine.eval(script3);

    Invocable inv = (Invocable) engine;

    inv.invokeFunction("hello", "Scripting!!");  //This one works.

    System.out.println(inv.invokeFunction("getValue", "22", "33"));
    System.out.println(inv.invokeFunction("foo", "Number"));
    System.out.println(inv.invokeFunction("foo", "22"));
  }
}




