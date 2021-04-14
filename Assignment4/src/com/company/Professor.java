package com.company;

import java.util.Stack;
import java.util.Vector;

public class Professor implements Runnable {
    private Stack<Point> pointStack = new Stack<Point>();
    private Stack<Line> lineStack = new Stack<Line>();
    @Override
    public void run() {



        while(true) {
            System.out.println("Professor is Here: ");
            pointStack = Repository.getInstance().getPoints();
            lineStack = Repository.getInstance().getLines();
            if(pointStack.size() >=6){//no need to test when there's less that 6 dots
                for(int i = 0; i < pointStack.size(); i++){
                    Fiver(pointStack.get(i));
                }

            }



            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

    }



    public void Fiver(Point p){ //for a given point, look through list of lines and see how many times comes up
        int count = 0;
        Vector<Line> found = new Vector<Line>();// to track found points
        Stack<Point> otherPoint = new Stack<Point>();
        for(int i = 0; i < lineStack.size(); i++) {
            if (lineStack.get(i).getA() == p ) {
                count++;
                found.add(lineStack.get(i));
                otherPoint.add(lineStack.get(i).getB());
            }
            else if(lineStack.get(i).getB() == p){
                count++;
                found.add(lineStack.get(i));
                otherPoint.add(lineStack.get(i).getB());
            }
        }
        if(count >= 5){// if point is in 5 or more lines remove it and the lines
            Repository.getInstance().removePoint(p);
            for(int i = 0; i <found.size(); i++){
                Repository.getInstance().removeLine(found.get(i));
            }
            for(int i = 0; i <otherPoint.size(); i++){
                //Repository.getInstance().addLine(ShortestLine(otherPoint.get(i)));

            }



        }




    }

    public Line ShortestLine(Point a){
        pointStack = Repository.getInstance().getPoints();
        double length;
        Point b;
        if (pointStack.get(0) != a ){
            length = setDistance(a, pointStack.get(0));
            b = pointStack.get(0);
        }
        else{
            length = setDistance(a, pointStack.get(1));
            b = pointStack.get(1);
        }

        for(int i=0; i <pointStack.size(); i++){
            if(pointStack.get(i) == a){

            }
            else if(setDistance(a,pointStack.get(i)) < length){
                length = setDistance(a,pointStack.get(i));
                b = pointStack.get(i);
            }
        }
        return new Line(a, b, length);
    }

    private double setDistance(Point a, Point b){
        return Math.sqrt(((b.getY() - a.getY())^2)+((b.getX()-a.getX())^2));
    }

}
