package Tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;



public class TimerActionListener implements ActionListener {
    GamePanel g;

    public TimerActionListener(GamePanel g) {
        this.g = g;
    }

    public void actionPerformed(ActionEvent e) {
        List<GameObject> gameobjects = this.g.gameobjects;

        for(int i = 0; i < gameobjects.size(); ++i) {
            GameObject go = (GameObject)gameobjects.get(i);
            if (go.isMovingUp()) {
                MoveUpCommand mv = new MoveUpCommand(go);
                mv.execute();
            } else {
                MoveDownCommand mv = new MoveDownCommand(go);
                mv.execute();
            }
        }

        boolean alloffscreen = true;

        for(int i = 0; i < gameobjects.size(); ++i) {
            GameObject go = (GameObject)gameobjects.get(i);
            if (!go.hasMovedOffScreen()) {
                alloffscreen = false;
                break;
            }
        }

        if (alloffscreen)
        {
            gameobjects.clear();
            this.g.generateObjects();
        }

        this.g.repaint();
    }
}
