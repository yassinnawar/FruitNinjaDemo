package Tools;

public class MoveUpCommand implements Command {
    GameObject gameobject;

    public MoveUpCommand(GameObject gameobject) {
        this.gameobject = gameobject;
    }

    public void execute() {
        this.gameobject.MoveUp();
    }
}

