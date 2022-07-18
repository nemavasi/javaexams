package javaexams.templates.behavioral.state;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArchiveState implements IState {

    private Date archiveDate = new Date();

    @Override
    public void print() {
        System.out.println("printing with archive date = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(archiveDate));
    }
}
