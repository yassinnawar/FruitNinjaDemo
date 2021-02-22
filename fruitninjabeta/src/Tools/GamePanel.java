package Tools;


import java.awt.*;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class GamePanel extends JPanel {

    ArrayList<GameObject> gameobjects = new ArrayList();
    ArrayList<GameObject> items = new ArrayList();
    Factory f = new Factory();
    Timer t;
    Random r = new Random();
    int xloc = 200+r.nextInt(50);
    int yloc = 400;

    private JLabel background1;
    private int no =3;
    private  int i=1;
    private ArrayList<GameObject> sliced = new ArrayList();
    private ArrayList<GameObject> notSliced = new ArrayList();

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel lives;
    private JLabel noOfLivesLeft;
    public int Lives;

    private JLabel live1 ;
    private JLabel live2 ;
    private JLabel live3 ;

   // private StopWatch stopwatch;



    public GamePanel()
    {
        setLives(3);
        initComponents();
        this.generateObjects();
        TimerActionListener tl = new TimerActionListener(this);
        this.t = new Timer(100, tl);
        this.t.start();
        MouseMotion m = new MouseMotion(this);
        this.addMouseMotionListener(m);
       // float k= this.getTime();

    }
    public void updateXLocation()
    {
        int k= r.nextInt(200);
        if (k<80) xloc=200+80;
        else xloc=200+k;
    }

    public void initComponents()
    {
       // stopwatch = new StopWatch();
        //stopwatch.start();
    }
        //Thread.sleep(5000);
       // System.out.println("Time elapsed in seconds: " + stopwatch.getElapsedTimeSeconds());


    //public float getTime() { return stopwatch.getElapsedTimeSeconds(); }

    public void generateObjects() {

        int noofshapes = r.nextInt(3) + 1;
        int xloc = 200+r.nextInt(50);
        int yloc = 400;

        for(int i = 0; i < noofshapes; ++i)
        {
            GameObject g = this.generateRandomObject();
            g.setXLocation(xloc);
            g.setYLocation(yloc);
            this.gameobjects.add(g);
            items.add(g);
            xloc +=200;
        }

    }

    public void getSlicedFruits()
    {
        for (GameObject temp : items)
        {
            if (temp.isSliced()==true)
            sliced.add(temp);
            else notSliced.add(temp);
        }
    }



    public GameObject generateRandomObject()
    {
        for (;i<=no;i++)
        {
            // get sliced fruits getSlicedFruits();
            r = new Random();
            int x = r.nextInt(8);
                 if (x == 0) return this.f.getObject("apple");
            else if (x == 1) return this.f.getObject("orange");
            else if (x == 2) return this.f.getObject("watermelon");
            else if (x == 3) return this.f.getObject("strawberry");
            else if (x == 4) return this.f.getObject("sBomb");
            else if (x == 5) return this.f.getObject("pineapple");
            else if (x == 6) return this.f.getObject("bBomb");
            else if (x == 7) return this.f.getObject("banana");
            else return this.f.getObject("strawberry");
        }
        return this.f.getObject("orange");
    }


    protected void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        ImageIcon img = new ImageIcon("background.jpg");
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);

        for(int i = 0; i < this.gameobjects.size(); ++i)
        {
            GameObject go = (GameObject)this.gameobjects.get(i);
            if (!go.isSliced()) {g.drawImage(go.getBufferedImage().getImage(), go.getXLocation(), go.getYLocation(), this); }
            else{ g.drawImage(go.getBufferedImage().getImage(), go.getXLocation(), go.getYLocation(), this); }
        }

    }

    public void setLives(int l) { Lives = l; }
    public int getLives(){return this.Lives;}

    public void loselife()
    {
        if (Lives>0)
        {
            Lives -=1;
            this.setLives(Lives);
        }
        else { JOptionPane.showInputDialog(" heyy"); }
    }

//    public void updateTime(float y)
//    {
//
//
//    }

}



