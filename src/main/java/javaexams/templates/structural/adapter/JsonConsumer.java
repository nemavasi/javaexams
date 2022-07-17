package javaexams.templates.structural.adapter;

public class JsonConsumer {
    public void consume(IJsonContent jsonData) {
        System.out.println(jsonData.getJsonContent());
    }
}
