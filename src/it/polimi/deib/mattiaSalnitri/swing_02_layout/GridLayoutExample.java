package it.polimi.deib.mattiaSalnitri.swing_02_layout;

/*
 * A Java swing FlowLayout example
 */

import javax.swing.*;
import java.awt.*;

/**
 * creates a swing window with the grid layout
 */
public class GridLayoutExample {

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
        JButton jb4 = new JButton("Button 4");
        JButton jb5 = new JButton("Button 5");

        // Define the panel to hold the buttons
        JPanel panel = new JPanel();

        // Define the panel to hold the buttons
        panel.setLayout(new GridLayout(3, 2));
        panel.add(jb1);
        panel.add(jb2);
        panel.add(jb3);
        panel.add(jb4);
        panel.add(jb5);

        //add panel to the frame
        frame.add(panel);

        //Sizes the frame so that all its contents are at or above their preferred sizes.
        frame.pack();

        // Set the window to be visible as the default to be false
        frame.setVisible(true);
    }

}
