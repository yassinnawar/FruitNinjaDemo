package Tools;

public class MoveDownCommand implements Command {
    GameObject gameobject;

    public MoveDownCommand(GameObject gameobject) {
        this.gameobject = gameobject;
    }

    public void execute() {
        this.gameobject.MoveDown();
    }
}
