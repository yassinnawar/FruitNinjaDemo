package javaapplication21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenu extends JFrame {


    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JFrame frame;


    public MainMenu() {
        createUIComponents();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("555");
                //frame.setVisible(false);
                gameframeold g = new gameframeold();
                g.setVisible(true);

            }
        });
    }

    private void createUIComponents() {

        button1 = new JButton("Start Game");
        button2 = new JButton("High Scores");
        button3 = new JButton("Exit");
      //  this.add(button1);
        //this.add(button2);
       // this.add(button3);

        GroupLayout l= new GroupLayout(this);
        //this.getContentPane().setLayout(g);
      l.setVerticalGroup( l.createSequentialGroup().addComponent(button1).addComponent(button2).addComponent(button3));

      l.setHorizontalGroup(l.createParallelGroup().addComponent(button1).addComponent(button2).addComponent(button3));

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

      //  this.setLocation(150, 250);
        this.setVisible(true);
    }

    protected void paintComponent(Graphics g) {

        this.paintComponent(g);
        ImageIcon img = new ImageIcon("background.jpg");
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);

    }
}