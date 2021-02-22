package Tools;

//import javax.swing.text.Highlighter;
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Player {

    private static Player p = null;
    private int HighScore;

    public int getHighScore() {
        return HighScore;
    }

    public void setHighScore(int highScore) {
        HighScore = highScore;
    }

    private List<Observer> myobservers = new ArrayList();
    private int Score;

    private Player()
    {
    }

    public void attach(Observer o) {
        this.myobservers.add(o);
    }

    public void notifyallObservers() {
        Iterator var1 = this.myobservers.iterator();
        while (var1.hasNext()) {
            Observer x = (Observer) var1.next();
            x.Update();
        }
    }

    public int getScore() {
        return this.Score;
    }


    public void setScore(int Score) {
        this.Score = Score;
        this.notifyallObservers();
    }

    public static Player getInstance() {
        if (p == null) {
            p = new Player(); }
        return p; }
}

