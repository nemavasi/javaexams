package javaexams.templates.behavioral.state;

public class ClientCode {

    public static void main(String[] args) {
        Document document = new Document();
        document.print();

        document.changeState(new SentState());
        document.print();

        document.changeState(new ApprovedState());
        document.print();

        document.changeState(new ArchiveState());
        document.print();
    }
}
//    draft printing is not allowed!
//    printing sent message!
//    printing with sign
//    printing with archive date = 2022-07-18 12:30:52