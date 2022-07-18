package javaexams.templates.behavioral.memento;

import java.util.ArrayList;
import java.util.List;
import javaexams.templates.behavioral.memento.Document.DocumentSnapshot;

public class DocumentHistory {

    private final Document document;
    private final List<DocumentSnapshot> snapshots = new ArrayList<>();

    public DocumentHistory(Document document) {
        this.document = document;
    }

    public List<DocumentSnapshot> getSnapshots() {
        return snapshots;
    }

    public void addSnapshot(DocumentSnapshot snapshot){
        snapshots.add(snapshot);
    }
}
