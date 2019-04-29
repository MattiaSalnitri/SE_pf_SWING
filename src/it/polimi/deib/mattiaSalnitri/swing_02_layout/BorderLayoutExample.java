package it.polimi.deib.mattiaSalnitri.swing_02_layout;

/*
 * A Java swing FlowLayout example
 */

import javax.swing.*;
import java.awt.*;

/**
 * creates a swing window with the Border layout
 */
public class BorderLayoutExample {

    public static void main(String[] args)
    {
        //set the frame look and feel: in windows it will not cover the task bar, in mac noting will change
        JFrame.setDefaultLookAndFeelDecorated(true);

        //set title
        JFrame frame = new JFrame("Title");

        //set behaviour on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define new buttons with different regions
        JButton jb1 = new JButton("NORTH");
        JButton jb2 = new JButton("SOUTH");
        JButton jb3 = new JButton("WEST");
        JButton jb4 = new JButton("EAST");
        JButton jb5 = new JButton("CENTER");

        // Define the panel to hold the buttons
        JPanel panel = new JPanel();

        //set orientation ( this is the default and wont change anything with NORD, SOUTH, WEST AND EST.
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        //set the layout
        panel.setLayout(new BorderLayout());

        //set the layout with gaps between elements
        //panel.setLayout(new BorderLayout(10,20));

        //add the buttons
        panel.add(jb1, BorderLayout.NORTH);
        panel.add(jb2, BorderLayout.SOUTH);
        panel.add(jb3, BorderLayout.WEST);
        panel.add(jb4, BorderLayout.EAST);
        panel.add(jb5, BorderLayout.CENTER);

        //add panel to the frame
        frame.add(panel);

        //Sizes the frame so that all its contents are at or above their preferred sizes.
        frame.pack();

        // Set the window to be visible as the default to be false
        frame.setVisible(true);
    }

}
