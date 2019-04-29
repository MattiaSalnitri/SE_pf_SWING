package it.polimi.deib.mattiaSalnitri.swing_02_layout;

/*
 * A Java swing FlowLayout example
 */

import javax.swing.*;
import java.awt.*;

/**
 * creates a swing window with the flow layout and a JPanel
 */
public class FlowLayoutExample_withPanel {

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


        // Define the panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); //with panel i can set different layout on the same jframe
        // why to use pane?  -> https://stackoverflow.com/questions/18870729/what-is-the-purpose-of-panels-in-java

        //add the buttons to the panel
        panel.add(jb1);
        panel.add(jb2);
        panel.add(jb3);

        //add panel to the frame
        frame.add(panel);

        //Sizes the frame so that all its contents are at or above their preferred sizes.
        frame.pack();

        // Set the window to be visible as the default to be false
        frame.setVisible(true);
    }

}
