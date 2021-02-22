
package Tools;

import javax.swing.ImageIcon;

public interface GameObject {

    void slice();

    boolean hasMovedOffScreen();

    void setMovedOff(boolean moved);

    boolean isMovingUp();

    boolean isSliced();

    void setMovingUp(boolean movingUp);

    int getXLocation();

    void setXLocation(int x);

    int getYLocation();

    int getInitialVelocity();

    int getFallingVelocity();

    void setYLocation(int y);

    ImageIcon getBufferedImage();

    void MoveUp();

    void MoveDown();

    void setName();
    String getName();
}
