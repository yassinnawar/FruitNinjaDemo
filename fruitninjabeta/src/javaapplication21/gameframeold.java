package javaapplication21;


import Tools.GamePanel;
import Tools.Observer;
import Tools.Player;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class gameframeold extends JFrame implements Observer {

    private JPanel gamePanel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel lives;
    private JLabel noOfLivesLeft;
    private int Lives=3;



    public gameframeold() {
        this.initComponents();
        Player.getInstance().attach(this);
    }

    private void initComponents()
    {

        this.gamePanel = new GamePanel();
        this.add(gamePanel);
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.lives= new JLabel();
        this.noOfLivesLeft= new JLabel(String.valueOf(this.Lives));
        this.setDefaultCloseOperation(3);
        GroupLayout gamePanel1Layout = new GroupLayout(this.gamePanel);
        this.gamePanel.setLayout(gamePanel1Layout);
        gamePanel1Layout.setHorizontalGroup(gamePanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 585, 32767));
        gamePanel1Layout.setVerticalGroup(gamePanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 309, 32767));
        this.jLabel1.setText("Score");
        this.jLabel2.setText("0");
        this.lives.setText("Lives");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.gamePanel, -2, -1, -2).addGap(55, 55, 55).addComponent(this.jLabel1, -2, 31, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel2, -2, 31, -2)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.gamePanel, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGap(36, 36, 36).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel2)).addContainerGap(-1, 32767)));
        this.pack();
        this.setSize(1000,1000);
        this.setLocation(300,150);
        this.add(lives);
        this.add(noOfLivesLeft);

        this.setVisible(true);

    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(gameframeold.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(gameframeold.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(gameframeold.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(gameframeold.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new gameframeold()).setVisible(true);
            }
        });



        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")));
        } catch (IOException |FontFormatException e) {
            //Handle exception
        }
    }

    public void Update() {
        this.jLabel2.setText(Player.getInstance().getScore() + "");
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void GameOver(GamePanel q)
    {
        this.setVisible(false);


    }

}
