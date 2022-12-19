package serveur;

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
		this.setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(connected());
    }

    public JPanel connected(){
        JPanel panel= new JPanel();
        panel.setLayout(null);
        JLabel online= new JLabel("En ligne");
		online.setBounds(100, 20, 100, 30);
        textArea= new JTextArea();
        textArea.setBounds(20,80, 300, 300); 
        panel.add(textArea);
        panel.add(online);
        return panel;
    }
}