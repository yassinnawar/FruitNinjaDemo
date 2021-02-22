package Tools;

import javax.swing.*;
import java.util.Random;

public class Banana extends Fruit {
    boolean movingUp = true;
    boolean movedoffScreen = false;
    boolean sliced = false;
    int x;
    int y;
    String Name;

    public Banana() { setName(); }


    @Override public void setName() { this.Name = "Banana"; }
    @Override public String getName() {
        return this.Name;
    }



    public boolean isMovingUp() {
        return this.movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public void slice() {
        this.sliced = true;
    }

    public int getXLocation() {
        return this.x;
    }

    public void setXLocation(int x) {
        this.x = x;
    }

    public int getYLocation() {
        return this.y;
    }

    public void setYLocation(int y) {
        this.y = y;
    }

    public ImageIcon getBufferedImage()
    {
        if (sliced==true) return new ImageIcon("slicedbanana.png");
       else return new ImageIcon("banana.png");

    }

    @Override
    public void MoveUp()
    {
        Random r = new Random();
        int m = r.nextInt(30);
        if (m<10) m=15;
        int newy = this.y - m;
        //int newx = this.x - m;
        //this.x = newx;
        this.y = newy;
        if (newy < 20) {
            this.setMovingUp(false);
        }


    }

    @Override
    public void MoveDown()
    {
        int newy = this.y + this.getFallingVelocity();
        this.setYLocation(newy);
        if (newy > 600)
        {
            this.setMovedOff(true);
        }
    }

    public int getInitialVelocity() {
        return 20;
    }

    public int getFallingVelocity() {
        return 30;
    }

    public boolean isSliced() {
        return this.sliced;
    }

    public boolean hasMovedOffScreen() {
        return this.movedoffScreen;
    }

    public void setMovedOff(boolean moved) {
        this.movedoffScreen = moved;
    }
}

