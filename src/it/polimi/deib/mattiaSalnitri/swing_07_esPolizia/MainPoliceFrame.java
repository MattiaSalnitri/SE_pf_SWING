package it.polimi.deib.mattiaSalnitri.swing_07_esPolizia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * class that manges the main frame
 */
public class MainPoliceFrame
{
    //the alar hanler isnatnce
    private AlarmHandler ah;

    public static void main(String[] args)
    {

        MainPoliceFrame mpf = new MainPoliceFrame();

    }

    /**
     * constructor of the frame
     */
    public MainPoliceFrame()
    {

        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(2,1));


        //buttons
        JPanel zonesJP = new JPanel();
        zonesJP.setLayout(new GridLayout(3,3));
        JButton jb1 = new JButton("Zone 1");
        jb1.setActionCommand("1");
        jb1.addActionListener(new CustomActionListener());

        JButton jb2 = new JButton("Zone 2");
        jb2.setActionCommand("2");
        jb2.addActionListener(new CustomActionListener());

        JButton jb3 = new JButton("Zone 3");
        jb3.setActionCommand("3");
        jb3.addActionListener(new CustomActionListener());

        JButton jb4 = new JButton("Zone 4");
        jb4.setActionCommand("4");
        jb4.addActionListener(new CustomActionListener());

        JButton jb5 = new JButton("Zone 5");
        jb5.setActionCommand("5");
        jb5.addActionListener(new CustomActionListener());

        JButton jb6 = new JButton("Zone 6");
        jb6.setActionCommand("6");
        jb6.addActionListener(new CustomActionListener());

        zonesJP.add(jb1);
        zonesJP.add(jb2);
        zonesJP.add(jb3);
        zonesJP.add(jb4);
        zonesJP.add(jb5);
        zonesJP.add(jb6);


        mainFrame.add(zonesJP);

        //text area
        JTextArea alertsTA = new JTextArea();

        mainFrame.add(alertsTA);

        //create the handler
        ah = new AlarmHandler(alertsTA);


        mainFrame.pack();
        mainFrame.setVisible(true);



    }

    /**
     * class that manages the events of the buttons
     */
    class CustomActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            ah.setAlarm(e.getActionCommand());
        }
    }
}
