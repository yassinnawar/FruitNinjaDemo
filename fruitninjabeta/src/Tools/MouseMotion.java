package Tools;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.util.Iterator;

public class MouseMotion  implements MouseMotionListener
{
    GamePanel g;

    int m;

    public MouseMotion(GamePanel g) {
        this.g = g;

    }


    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Iterator itr = this.g.gameobjects.iterator();

        while(itr.hasNext()) {
            GameObject ob1 = (GameObject)itr.next();
            if (x >= ob1.getXLocation() && x <= ob1.getXLocation() + ob1.getBufferedImage().getIconWidth() && y >= ob1.getYLocation() && y <= ob1.getYLocation() + ob1.getBufferedImage().getIconHeight() && !ob1.isSliced()) {
                ob1.setMovingUp(false);
                ob1.slice();
                if((ob1.getName()=="Apple")||(ob1.getName()=="Orange")||(ob1.getName()=="Banana")||(ob1.getName()=="StrawBerry"))
                    m = this.getScore(1);
                else m= this.getScore(2);
                if (ob1.getName()=="Small Bomb")
                {
                    g.loselife();
                }
                if(ob1.getName()=="Mighty Bomb"){


                    // end game bomb
                }
                int sc = Player.getInstance().getScore();
                Player.getInstance().setScore(sc + m);
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

       // g.updatetime();
        //g.getTime();


    }


    public int getScore(int x )
    {
        if(x==1) return 10;
        else if (x==2) return 30;
        else return 10;
    }
}








