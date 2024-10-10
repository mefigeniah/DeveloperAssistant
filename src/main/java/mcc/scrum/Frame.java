package mcc.scrum;

import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {

    Frame() {
        this.setTitle("Code Mirror");
        this.setBounds(300,300,300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(new Panel());
        this.setVisible(true);

    }
}

