package it.polimi.deib.mattiaSalnitri.swing_02_layout;

/*
 * A Java swing FlowLayout example
 */

import javax.swing.*;
import java.awt.*;

/**
 * creates a swing window with the grid bag layout
 */
public class GridBagLayoutExample {

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
        JButton jb4 = new JButton("very very Long-Named Button 4");
        JButton jb5 = new JButton("Button 5");
        JButton jb6 = new JButton("Button 6");
        JButton jb7 = new JButton("Button 7");

        // Define the panel to hold the buttons
        JPanel panel = new JPanel();

        // Define the panel to hold the components
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);

        //define the constraints
        GridBagConstraints gbc = new GridBagConstraints();
        //set place
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(jb1, gbc); //gdc reset


        // You will find examples where  they use one GridBagConstraints instance for all the components the GridBagLayout manages,
        // however in real-life situations it is recommended that you do not reuse GridBagConstraints,
        // as this can very easily lead to you introducing subtle bugs if you forget to reset the fields for each new instance.
        // Just before each component is added to the container, the code sets (or resets to default values) the appropriate
        // instance variables in the GridBagConstraints object.
        // It then adds the component to its container, specifying the GridBagConstraints object as the second argument to the add method.
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html


        GridBagConstraints gbc2 = new GridBagConstraints();
        //set place
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        //set spacing
        gbc2.insets = new Insets(5, 5, 5, 115); // top, left, bottom, right
        panel.add(jb2, gbc2);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 2;
        gbc3.gridy = 0;
        panel.add(jb3, gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 2;
        gbc4.gridwidth = 2; //the name is very long, the element are spaced
        gbc4.ipady = 25; //set additional size
        panel.add(jb4, gbc4);


        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 3;
        gbc4.gridwidth = 3;
        panel.add(jb5, gbc5);

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.fill = GridBagConstraints.HORIZONTAL; //fill it all the space assigned
        gbc6.gridx = 0;
        gbc6.gridy = 4;
        gbc6.gridwidth = 3;
        panel.add(jb6, gbc6);

        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 0;
        gbc7.gridy = 5;
        gbc7.gridwidth = 3;
        //gbc7.gridheight = 3;
        gbc7.anchor = GridBagConstraints.LAST_LINE_END;//placed in the left most position. if not specified, the anchor is set to CENTER
        panel.add(jb7, gbc7);
        

        //add panel to the frame
        frame.add(panel);

        //Sizes the frame so that all its contents are at or above their preferred sizes.
        frame.pack();

        // Set the window to be visible as the default to be false
        frame.setVisible(true);
    }

}
