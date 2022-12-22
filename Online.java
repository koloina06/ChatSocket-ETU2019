package serveur;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class Online extends JFrame{
    JTextArea textArea;
    
    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public Online(){
        this.setVisible(true);
		this.setSize(350,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(connected());
    }

    public JPanel connected(){
        Font font = new Font(Font.DIALOG,  Font.BOLD, 15);
        JPanel panel= new JPanel();
        panel.setLayout(null);
        JLabel online= new JLabel("Clients en ligne");
		online.setBounds(100, 20, 100, 30);
        online.setFont(font);
        textArea= new JTextArea();
        textArea.setBounds(20,80, 300, 300); 
        textArea.setBackground(Color.BLACK);
        textArea.setFont(font);
        textArea.setForeground(Color.white);
        panel.add(textArea);
        panel.add(online);
        return panel;
    }
}