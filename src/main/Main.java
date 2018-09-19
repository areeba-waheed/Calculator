package main;
import javax.swing.JFrame;

/**
 *  Areeba Waheed
 *  SEP 17, 2018
 *  Comp 585: GUI
 *  Project 1: Calculator
 *
 **/
public class Main {

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new BuildFrame();
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
