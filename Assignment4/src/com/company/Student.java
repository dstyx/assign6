package com.company;

import java.util.Stack;

public class Student implements Runnable {


    private Stack<Point> pointStack = new Stack<Point>();

    public Student(){

    }
    @Override
    public void run() {


        //while(true){
            System.out.println("Student is Here: ");
            pointStack = Repository.getInstance().getPoints();
            if(pointStack.size() >1){
                Repository.getInstance().addLine(ShortestLine());
                //System.out.println("running shortest line");

            }
            try{
                Thread.sleep(1000);
            } catch(Exception e){
                System.out.println(e.toString());
            }
        //}
    }

    public Line ShortestLine(){
        /*
        Point a = pointStack.get(pointStack.size()-1);
        Line shortest = new Line(a, pointStack.get(0));
        for(int i = 0; i < pointStack.size(); i++){

        }

         */
        double length = setDistance(pointStack.get(pointStack.size()-1), pointStack.get(0));
        Point a = pointStack.get(pointStack.size()-1);
        Point b = pointStack.get(0);
        for(int i=0; i <pointStack.size(); i++){
            if(pointStack.get(i) == a){

            }
            else if(setDistance(pointStack.get(pointStack.size()-1),pointStack.get(i)) < length){
                length = setDistance(pointStack.get(pointStack.size()-1),pointStack.get(i));
                b = pointStack.get(i);
            }
        }
        return new Line(a, b, length);
    }

    private double setDistance(Point a, Point b){
        return Math.sqrt(((b.getY() - a.getY())^2)+((b.getX()-a.getX())^2));
    }


}
