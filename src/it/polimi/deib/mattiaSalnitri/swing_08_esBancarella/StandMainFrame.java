package it.polimi.deib.mattiaSalnitri.swing_08_esBancarella;

import javax.swing.*;
import java.awt.*;

/**
 * main class, set up the GUI
 */
public class StandMainFrame
{
    FruitHandler fh;

    public static void main(String[] args)
    {
        StandMainFrame smf = new StandMainFrame();
    }

    /**
     * constructure, sets up the GUI
     */
    public StandMainFrame()
    {

        fh = new FruitHandler();

        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(2,1));


        //labels
        JPanel labels = new JPanel();
        labels.setLayout(new GridLayout(3,2));

        JLabel tomatosL = new JLabel("Number of tomatos");
        JLabel tomatosQL = new JLabel("0");

        JLabel potatosL = new JLabel("Number of potatos");
        JLabel potatosQL = new JLabel("0");

        JLabel basilsL = new JLabel("Number of basils");
        JLabel basilsQL = new JLabel("0");

        labels.add(tomatosL);
        labels.add(tomatosQL);

        labels.add(potatosL);
        labels.add(potatosQL);

        labels.add(basilsL);
        labels.add(basilsQL);

        //buttons
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3,1));

        JButton produceTomatoJB = new JButton("Produce Tomato");
        produceTomatoJB.addActionListener(new CustomActionListener(fh, "tomato", tomatosQL));

        JButton producePotatoJB = new JButton("Produce Potato");
        producePotatoJB.addActionListener(new CustomActionListener(fh, "potato", potatosQL));

        JButton prodiceBasilJB = new JButton("Produce Basil");
        prodiceBasilJB.addActionListener(new CustomActionListener(fh, "basil", basilsQL));

        buttons.add(produceTomatoJB);
        buttons.add(producePotatoJB);
        buttons.add(prodiceBasilJB);


        //add the panels
        mainFrame.add(buttons);
        mainFrame.add(labels);

        mainFrame.pack();
        mainFrame.setVisible(true);

        //start the consumer thread
        Customer c = new Customer(fh, tomatosQL, potatosQL, basilsQL);

    }
}
