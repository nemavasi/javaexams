package javaexams.templates.behavioral.command;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class ClientCode {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Commands");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setContentPane(new JPanel());
        jFrame.getContentPane().setBounds(0, 0 ,300, 300);

        JButton insertBtn = new JButton("insert");
        insertBtn.addActionListener(actionEvent -> new InsertCommand().execute());

        JButton updateBtn = new JButton("update");
        updateBtn.addActionListener(actionEvent -> new UpdateCommand().execute());

        JButton deleteBtn = new JButton("delete");
        deleteBtn.addActionListener(actionEvent -> new DeleteCommand().execute());

        jFrame.getContentPane().add(insertBtn);
        jFrame.getContentPane().add(updateBtn);
        jFrame.getContentPane().add(deleteBtn);


        Action doInsert = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                new InsertCommand().execute();
            }
        };
        insertBtn.getInputMap().put(KeyStroke.getKeyStroke("F2"),
            "doInsert");
        insertBtn.getActionMap().put("doInsert",
            doInsert);

        jFrame.setSize(400, 400);

        jFrame.setVisible(true);
    }
}
