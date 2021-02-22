package javaapplication21;

import Tools.GamePanel;
import Tools.Observer;
import Tools.Player;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class newgame extends JFrame implements Observer
{

    private JPanel gamePanel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel lives;
    private JLabel noOfLivesLeft;
    public int Lives;
    private JPanel ScoreBoard;
    private JLabel live1 ;
    private JLabel live2 ;
    private JLabel live3 ;



    public newgame()
    {
        this.initComponents();
        Player.getInstance().attach(this);

    }

    private void initComponents()
    {
        this.gamePanel = new GamePanel();

        this.ScoreBoard= new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
////        ScoreBoard.add(live1);
////        ScoreBoard.add(live2);
////        ScoreBoard.add(live3);
//        ScoreBoard.add(jLabel1);
//        ScoreBoard.add(jLabel2);
//        //ScoreBoard.setBounds(20,30,200,300);
//
//
//        BorderLayout layout = new BorderLayout();
//
//        layout.addLayoutComponent(gamePanel,BorderLayout.CENTER);
//        layout.addLayoutComponent(ScoreBoard,BorderLayout.NORTH);
//
//
////        this.live1 = new JLabel(new ImageIcon("live.png"));
////        this.live2 = new JLabel(new ImageIcon("live.png"));
////        this.live3 = new JLabel(new ImageIcon("live.png"));
////////
//
//
//        gamePanel.setSize(700,700);
//
//        this.setLayout(layout);
        this.pack();
        this.setSize(1000,1000);
        this.setLocation(300,150);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                UIManager.LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(newgame.class.getName()).log(Level.SEVERE, (String) null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(newgame.class.getName()).log(Level.SEVERE, (String) null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(newgame.class.getName()).log(Level.SEVERE, (String) null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(newgame.class.getName()).log(Level.SEVERE, (String) null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new newgame()).setVisible(true);
            }
        });
    }
//Handle Exception


    private void createUIComponents() { }

    public void GameOver(GamePanel q) { this.setVisible(false); }

    @Override
    public void Update() {
        this.jLabel2.setText(Player.getInstance().getScore() + "");
    }
}