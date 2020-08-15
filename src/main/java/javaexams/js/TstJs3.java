package javaexams.js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TstJs3 {
  public static void main(String[] args) throws Exception {

    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");

    // JavaScript code in a String
//    String script1 = "function transform(exportAnswer) {"
//        + " var obj = new Object(); "
//        + " var rec = {'fieldId' : 'EXP_ANS', 'value' : exportAnswer};"
//        + " obj.fields = [rec];"
//        + " return JSON.stringify(obj);"
//        + "}";


    String script1 = "function transform(exportAnswer) {"
        + " var ans = JSON.parse(exportAnswer);"
        + "  var filename = ans.parts[1].name;"
       // + " return \"{\"fields\\\": [{\"fieldId\\\": \"REG_FILE_ID\\\", \"value\": filename}]}\";"
        + " return \"{\\\"fields\\\": [{\\\"fieldId\\\": \\\"REG_FILE_ID\\\", \\\"value\\\": \\\"\" + filename + \"\\\"}]}\";"
       // + " return JSON.stringify(\"{\"fields\": [{\"fieldId\": \"REG_FILE_ID\", \"value\": filename}]}\");"
      + " }";




    engine.eval(script1);

    Invocable inv = (Invocable) engine;
    System.out.println(inv.invokeFunction("transform", "\t{\n" +
        "\t\t\t\"requestBodyType\": \"MULTIPART_FORM_DATA\",\n" +
        "\t\t\t\"parts\": [\n" +
        "\t\t\t{\n" +
        "\t\t\t\"name\": \"jsonPayload\",\n" +
        "\t\t\t\"contentType\": \"text/plain\",\n" +
        "\t\t\t\"text\": \"\\n\\t\\t{\\n\\t\\t\\\"records\\\": [\\n\\t\\t\\t\\t{\\n\\t\\t\\t\\t\\\"mode\\\": \\\"create\\\",\\n\\t\\t\\t\\t\\\"fields\\\": [\\n\\t\\t{\\n\\t\\t\\\"records\\\": [\\n\\t\\t{\\n\\t\\t\\\"mode\\\": \\\"create\\\",\\n\\t\\t\\\"fields\\\": [\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"last_name\\\",\\n\\t\\t\\\"value\\\": \\\"Кожаринов\\\"\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"first_name\\\",\\n\\t\\t\\\"value\\\": \\\"Р\\\"\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"middle_name\\\",\\n\\t\\t\\\"value\\\": \\\"А\\\"\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"birthday\\\",\\n\\t\\t\\\"value\\\": \\\"1990-04-30T00:00:00\\\"\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"gender_id\\\",\\n\\t\\t\\\"value\\\": \\\"2\\\"\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"doc_type_id\\\",\\n\\t\\t\\\"value\\\": 1\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"doc_number\\\",\\n\\t\\t\\\"value\\\": \\\"*****980\\\"\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"snils\\\",\\n\\t\\t\\\"value\\\": \\\"*****\\\"\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"phone\\\",\\n\\t\\t\\\"value\\\": \\\"*****-94\\\"\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"email\\\",\\n\\t\\t\\\"value\\\": \\\"rom\\\"\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"agent_last_name\\\",\\n\\t\\t\\\"value\\\": \\\"\\\"\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"agent_first_name\\\",\\n\\t\\t\\\"value\\\": \\\"\\\"\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"agent_middle_name\\\",\\n\\t\\t\\\"value\\\": \\\"\\\"\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"agent_doc_type_id\\\",\\n\\t\\t\\\"value\\\": \\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"agent_doc_number\\\",\\n\\t\\t\\\"value\\\": \\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"agent_phone\\\",\\n\\t\\t\\\"value\\\": \\\"\\\"\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"agent_email\\\",\\n\\t\\t\\\"value\\\": \\\"\\\"\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"status_id\\\",\\n\\t\\t\\\"value\\\": 1\\n\\t\\t},\\n\\t\\t{\\n\\t\\t\\\"fieldId\\\": \\\"mfile_id\\\",\\n\\t\\t\\\"value\\\": { \\\"formField\\\": \\\"-mfile_id-1603832\\\" }\\n\\t\\t}\\n\\t\\t}\\n\\t\\t]\\n\\t\\t}\\n\\t\\t]\\n\\t\\t}\\n\\t]\\n\\t\\t\\t\\t}\\n\\t\\t\\t]\\n\\t\\t}\\n\\t\"\n" +
        "\t\t\t},\n" +
        "\t\t\t{\n" +
        "\t\t\t\"name\": \"file-mfile_id-1603832\",\n" +
        "\t\t\t\"contentType\": \"application/octet-stream\",\n" +
        "\t\t\t\"binarySource\": \"2\",\n" +
        "\t\t\t\"filename\": \"pict.png\"\n" +
        "\t\t\t}\n" +
        "\t\t\t],\n" +
        "\t\t\t\"multipartMode\": \"BROWSER_COMPATIBLE\"\n" +
        "\t\t\t}"));

  }
}