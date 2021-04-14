package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

public class Canvas extends JPanel implements Observer {

    Stack<Point> points = null;
    Stack<Line> lines = null;

    public Canvas(){
        FlowLayout layoutPanel = new FlowLayout();
        JPanel panel = new JPanel(layoutPanel);
        panel.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        if(points != null) {
            for (int i = 0; i < points.size(); i++) {
                int x = points.get(i).getX();
                int y = points.get(i).getY();
                g.fillOval((x - 5), y - 25, 10, 10);
            }
        }
        if(lines != null){
            for (int i = 0; i <lines.size(); i++){
                g.drawLine(lines.get(i).getA().getX()-5,
                        lines.get(i).getA().getY()-20,
                        lines.get(i).getB().getX()-5,
                        lines.get(i).getB().getY()-20);
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {

        points = Repository.getInstance().getPoints();
        lines = Repository.getInstance().getLines();

        for(int i = 0; i <lines.size(); i++){
            System.out.println("Line " + i + " Contains these points: "+ lines.get(i).getA().getX()+
                    lines.get(i).getA().getY()+
                    lines.get(i).getB().getX()+
                    lines.get(i).getB().getY()+
                    " And a length of : " +
                    lines.get(i).getD());
        }
        /* DEBUG
        System.out.println("update being called");
        for(int i = 0; i < points.size(); i ++){
            System.out.println("Element: " + i + " has the x coordinate of: "+ points.get(i).getX()
                    + "and the Y coordinate of: " +points.get(i).getY());

        }

         */





        repaint();


    }
}
