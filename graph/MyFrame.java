package graph;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
    public MyFrame() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        MyPanel panel = new MyPanel();
        this.add(panel, BorderLayout.CENTER);

        Panel p1 = new Panel(new FlowLayout());
        this.add(p1, BorderLayout.SOUTH);
    }
}

