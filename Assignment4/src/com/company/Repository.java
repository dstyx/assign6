package com.company;

import java.util.Observable;
import java.util.Stack;

public class Repository extends Observable {

    private static Repository single_instance = null;
    private double totalDistance;
    private Stack<Point> v = new Stack<Point>();
    private Stack<Line> l =new Stack<Line>();

    Thread threadP = new Thread(new Professor());


    private Repository(){

        //threadS.start();
        threadP.start();

    }

    public static Repository getInstance(){
        if(single_instance == null)
            single_instance = new Repository();

        return single_instance;


    }

    public void addPoint(int x, int y){


        v.push(new Point(x,y));
        /*DEBUG
        if(v.size() <5)
            v.push(new Point(x,y));


        else if (v.size() == 5){
            v.remove(0);
            v.push(new Point(x,y));
        }
        */




        setChanged();

        notifyObservers();
        try{
            Thread.sleep(1000);

        } catch (InterruptedException e){
            System.out.println("Error Occurred.");
        }
        Thread threadS = new Thread(new Student());//to not overload cpu when many dots
        threadS.start();




    }

    public void addLine(Line a){
        l.push(a);
        setChanged();
        notifyObservers();


        try{
            Thread.sleep(1000);

        } catch (InterruptedException e){
            System.out.println("Error Occurred.");
        }

    }




    public Stack<Point> getPoints(){

        return v;

    }

    public Stack<Line> getLines(){
        return l;

    }


    public void removeLine(Line a){
        l.remove(a);
        setChanged();
        notifyObservers();


    }

    public void removePoint(Point p){
        v.remove(p);
        setChanged();
        notifyObservers();
    }

}
