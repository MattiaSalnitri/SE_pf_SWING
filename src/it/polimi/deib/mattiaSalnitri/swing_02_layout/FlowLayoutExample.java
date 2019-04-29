package it.polimi.deib.mattiaSalnitri.swing_02_layout;

/*
 * A Java swing FlowLayout example
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;

/**
 * creates a swing window with the flow layout
 */
public class FlowLayoutExample {

    public static void main(String[] args)
    {
        //set the frame look and feel: in windows it will not cover the task bar, in mac noting will change
        JFrame.setDefaultLookAndFeelDecorated(true);

        //set title
        JFrame frame = new JFrame("Title");

        //set behaviour on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define new buttons
        JButton jb1 = new JButton("Button 1");
        JButton jb2 = new JButton("Button 2");
        JButton jb3 = new JButton("Button 3");

        frame.setLayout(new FlowLayout());
        frame.add(jb1);
        frame.add(jb2);
        frame.add(jb3);

        frame.setSize(500,600);

        frame.setVisible(true);
    }

}
