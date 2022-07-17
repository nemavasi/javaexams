package javaexams.templates.structural.adapter;

public class ClientCode {

    public static void main(String[] args) {
        XMLData data = new XMLData();

        JsonConsumer consumer = new JsonConsumer();

        consumer.consume(new XMLtoJSONAdapter(data));
    }

}
//    xml content converted to json