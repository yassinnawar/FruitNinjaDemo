package Tools;

import java.util.ArrayList;

public class Factory

{
    private GameObject g;
    private ArrayList<GameObject> list = new ArrayList<GameObject>(5);
    private ArrayList<GameObject> sliced = new ArrayList<GameObject>(5);
    private ArrayList<GameObject> notSliced = new ArrayList<GameObject>(5);
//    public Factory(String obName)
//    {
//
//    }

    public GameObject getObject(String obName)
    {
        if (obName.equals("apple"))
        {
            g = new Apple();
            list.add(g);
        }
        if (obName.equals("orange"))
        {
            g = new Orange();
            list.add(g);
        }
        if (obName.equals("strawberry"))
        {
            g = new Strawberry();
            list.add(g);
        }
        if (obName.equals("watermelon"))
        {
            g = new WaterMelon();
            list.add(g);
        }
        if (obName.equals("sBomb"))
        {
            g = new sBomb();
          //doesn't add to list
        }
        if (obName.equals("bBomb"))
        {
            g = new bBomb();
            // doesn't add to list
        }
        if (obName.equals("banana"))
        {
            g = new Banana();
            list.add(g);
        }
        if (obName.equals("pineapple"))
        {
            g = new Pineapple();
            list.add(g);
        }
        return g;
    }



    public ArrayList<GameObject> getArrlist() {
        return list;
    }

    public void setArrlist(ArrayList<GameObject> list)
    {
        this.list = list;

    }


public void getSlicedFruits()
    {

        for (GameObject temp : list)
        {
//            if (temp.isSliced()==true)
//                sliced.add(temp);
          if(temp.isSliced()==true) sliced.add(temp);
          else notSliced.add(temp);
        }
        for (GameObject temp : sliced)
        {
            System.out.println(temp.getName());

        }
    }

}



//    public GameObject getObject(String obName)
//    {
//        if (obName.equals("apple")) return (GameObject) new Apple();
//        else if (obName.equals("strawberry")) return (GameObject) new Strawberry();
//        else if (obName.equals("orange")) return (GameObject) new Orange();
//        else if (obName.equals("watermelon")) return (GameObject) new WaterMelon();
//        else if (obName.equals("pineapple")) return (GameObject) new Pineapple();
//        else if (obName.equals("banana")) return (GameObject) new Banana();
//        else if (obName.equals("sBomb")) return (GameObject) new sBomb();
//        else if (obName.equals("bBomb")) return (GameObject) new bBomb();
//        else return  (GameObject) new Apple();
//
//    }



