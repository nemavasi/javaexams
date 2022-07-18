package javaexams.templates.behavioral.memento;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Document {

    private String name;
    private String creator;
    private String signer;
    private String number;
    private Date officialDate;
    private String text;


    DocumentSnapshot save(){
        Date now = new Date();
        DocumentSnapshot documentSnapshot =
            new DocumentSnapshot("snap-" + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"), now);

        documentSnapshot.name = name;
        documentSnapshot.creator = creator;
        documentSnapshot.signer = signer;
        documentSnapshot.number = number;
        documentSnapshot.officialDate = officialDate;
        documentSnapshot.text = text;
        return documentSnapshot;
    }

    public void restore(DocumentSnapshot documentSnapshot){
        this.name = documentSnapshot.name;
        this.creator = documentSnapshot.creator;
        this.signer = documentSnapshot.signer;
        this.number = documentSnapshot.number;
        this.officialDate = documentSnapshot.officialDate;
        this.text = documentSnapshot.text;
    }

    public static class DocumentSnapshot {

        private String snapshotName;
        private Date snapshotDate;

        private String name;
        private String creator;
        private String signer;
        private String number;
        private Date officialDate;
        private String text;

        public DocumentSnapshot(String snapshotName, Date snapshotDate) {
            this.snapshotName = snapshotName;
            this.snapshotDate = snapshotDate;
        }

        public String getSnapshotName() {
            return snapshotName;
        }

        public Date getSnapshotDate() {
            return snapshotDate;
        }

        @Override
        public String toString() {
            return "DocumentSnapshot{" +
                "snapshotName='" + snapshotName + '\'' +
                ", snapshotDate=" + snapshotDate +
                ", name='" + name + '\'' +
                ", creator='" + creator + '\'' +
                ", signer='" + signer + '\'' +
                ", number='" + number + '\'' +
                ", officialDate=" + officialDate +
                ", text='" + text + '\'' +
                '}';
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getOfficialDate() {
        return officialDate;
    }

    public void setOfficialDate(Date officialDate) {
        this.officialDate = officialDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Document{" +
            "name='" + name + '\'' +
            ", creator='" + creator + '\'' +
            ", signer='" + signer + '\'' +
            ", number='" + number + '\'' +
            ", officialDate=" + officialDate +
            ", text='" + text + '\'' +
            '}';
    }
}
