package Tools;

import javax.swing.*;
import java.util.Random;

public class bBomb extends Bomb {

    boolean movingUp = true;
    boolean movedOffScreen = false;

    boolean sliced = false;
    int x, y;
    public String Name;

    public bBomb()
    {setName(); }

    @Override
    public void setName()
    {
        this.Name = "Mighty Bomb";
    }

    @Override
    public String getName() {
        return this.Name; }

    @Override
    public boolean isMovingUp() {
        return movingUp;
    }

    @Override
    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    @Override
    public void slice() {
        sliced = true;
    }

    @Override
    public int getXLocation() {
        return x;
    }

    @Override
    public void setXLocation(int x) {
        this.x = x;
    }

    @Override
    public int getYLocation() {
        return y;
    }

    @Override
    public void setYLocation(int y) {
        this.y = y;
    }

    @Override
    public ImageIcon getBufferedImage()
    {
        if (sliced==true) return new ImageIcon("mighty_explosion.png");
        else return new ImageIcon("mighty_bomb.png");
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

    @Override
    public int getInitialVelocity() { return 8; }

    @Override
    public int getFallingVelocity() {
        return 20;
    }

    @Override
    public boolean isSliced() {
        return sliced;
    }

    public boolean hasMovedOffScreen() {
        return movedOffScreen;
    }

    @Override
    public void setMovedOff(boolean moved) {
        this.movedOffScreen = moved;
    }
}
