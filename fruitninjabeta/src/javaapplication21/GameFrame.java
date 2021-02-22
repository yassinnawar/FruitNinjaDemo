package javaapplication21;

import Tools.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.Timer;


public class GameFrame extends JFrame implements Observer {

    private JPanel gamePanel;

    private JLabel scoreLabel;
    private JLabel score;
    private JLabel live1 ;
    private JLabel live2 ;
    private JLabel live3 ;

    public int Lives;
    private long startTime;


    private ImageIcon Life;
    private ImageIcon lostLife;
    private JLabel time;
    //private EngineStart engine;
    private Timer t;


    private StopWatch s;
    public double runTime;





    public GameFrame()
    {
        this.initComponents();
        Player.getInstance().attach(this);
        MouseMotion m = new MouseMotion((GamePanel) gamePanel);
        this.addMouseMotionListener(m);
        this.Lives= ((GamePanel) gamePanel).getLives();
        //s= new StopWatch();
        //runTime= s.getElapsedTimeSeconds();

        new Timer(100, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {time.setText(String.valueOf(s.getElapsedTimeSeconds())); }
            }
            ).start();
        }





    private void initComponents()
    {

        this.gamePanel = new GamePanel();
        this.add(gamePanel);
        this.scoreLabel = new JLabel();
        this.score = new JLabel();

        Life= new ImageIcon("life.png");
        lostLife= new ImageIcon("loselife.png");

        s= new StopWatch();
        runTime =s.getElapsedTimeSeconds();
        this.time= new JLabel(String.valueOf((s.getElapsedTimeSeconds())));


        this.live1= new JLabel(Life);
        this.live2= new JLabel(Life);
        this.live3= new JLabel(Life);

        this.setDefaultCloseOperation(3);

        GroupLayout gamePanel1Layout = new GroupLayout(this.gamePanel);
        this.gamePanel.setLayout(gamePanel1Layout);
        gamePanel1Layout.setHorizontalGroup(gamePanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 585, 32767));
        gamePanel1Layout.setVerticalGroup(gamePanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 309, 32767));
        this.scoreLabel.setText("Score");
        this.score.setText("0");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout
                        .createSequentialGroup()
                        .addComponent(gamePanel)
                        .addGroup
                                (layout
                                        .createParallelGroup((GroupLayout.Alignment.LEADING))
                                        .addComponent(this.scoreLabel)
                                        .addComponent(this.live1)
                                        .addComponent(this.live2)
                                        .addComponent(this.live3)
                                )
                        .addGroup(
                        layout
                                .createParallelGroup((GroupLayout.Alignment.LEADING))
                                .addComponent(this.score)
                                .addComponent(this.time)
                        )
                        .addContainerGap(-1, 32767)

        );



        layout.setVerticalGroup
                (layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.gamePanel)
                        .addGroup
                                (layout
                                        .createSequentialGroup()
                                        .addComponent(this.scoreLabel)
                                        .addComponent(live1)
                                        .addComponent(live2)
                                        .addComponent(live3)
                                )
                        .addGroup
                                (layout
                                        .createSequentialGroup()
                                        .addComponent(this.score)
                                        .addComponent(this.time)
                                )
                        .addGroup
                                (layout
                                        .createSequentialGroup()
                                        .addContainerGap(-1, 32767)
                        )

                );


        this.pack();
        this.setSize(800,800);
        this.setLocation(50,150);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) { UIManager.setLookAndFeel(info.getClassName());
                    break; }} }
        catch (ClassNotFoundException var5) { Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, (String)null, var5); } catch (InstantiationException var6) { Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, (String)null, var6); } catch (IllegalAccessException var7) { Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, (String)null, var7); } catch (UnsupportedLookAndFeelException var8) { Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, (String)null, var8); }

        EventQueue.invokeLater(new Runnable() {public void run() { (new GameFrame()).setVisible(true); }});
        try { GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf"))); } catch (IOException |FontFormatException e) {}}
//Handle Exception


    private void createUIComponents() { }


    public void GameOver(GamePanel q) { this.setVisible(false); }

    @Override
    public void Update()
    {
        this.score.setText(Player.getInstance().getScore() + "");
        this.Lives= ((GamePanel) gamePanel).getLives();
        livesButtonsChanger();
        this.updateTime();



    }



    public void updateTime()
    {
        time.setText(String.valueOf(s.getElapsedTimeSeconds()));
    }

    private void livesButtonsChanger()
    {
        if (this.Lives==3)
        {
            live1.setIcon(Life);
            live2.setIcon(Life);
            live3.setIcon(Life);
        }
        else if (this.Lives==2)
        {
            live1.setIcon(Life);
            live2.setIcon(Life);
            live3.setIcon(lostLife);
        }

        else if (this.Lives==1)
        {
            live1.setIcon(Life);
            live2.setIcon(lostLife);
            live3.setIcon(lostLife);
        }
        else { live1.setIcon(lostLife);
        live2.setIcon(lostLife);
        live3.setIcon(lostLife); }

    }

}