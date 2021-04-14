package com.company;

public class Line {
    private Point a;
    private Point b;
    private double d;

    public Line(Point a, Point b, double d){
        this.a = a;
        this.b = b;
        this.d = d;
    }



    public Point getA(){ return a; }

    public Point getB(){ return b; }

    public double getD(){ return d; }

}
