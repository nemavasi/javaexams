package javaexams.templates.behavioral.memento;

public class ClientCode {

    public static void main(String[] args) {
        Document document = new Document();
        document.setCreator("Ivanov");
        document.setText("Text 1");
        document.setNumber("42");

        DocumentHistory history = new DocumentHistory(document);
        history.addSnapshot(document.save());

        System.out.println(document);

        document.setText("Text 2");
        document.setSigner("Petrov");

        System.out.println(document);

        document.restore(history.getSnapshots().get(0));

        System.out.println(document);

    }
}
