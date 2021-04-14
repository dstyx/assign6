package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main(){

        Canvas canvas = new Canvas();
        Reporter reporter = new Reporter();
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout( new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        addMouseListener(reporter);
        Repository.getInstance().addObserver(canvas);

    }

    public static void main(String[] args) {



        Main frame = new Main();
        frame.setVisible(true);


    }

}
