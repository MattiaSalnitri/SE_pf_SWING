package it.polimi.deib.mattiaSalnitri.swing_05_eventListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * create a window with one listener
 */
public class SimpleEventListener {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    //constructor
    public SimpleEventListener(){
        prepareGUI();
    }

    public static void main(String[] args)
    {
        //create an instance of the class
        //in this case it prepares the GUI, i/e/ instantiates all the elements
        SimpleEventListener  simpleEventListener = new SimpleEventListener();

        //thsi methos sets up the elements and add the listeners
        //it is separated couse we canuse the same elements abut change the behaviour and the content of the window, depending on the context/situation
        simpleEventListener.showActionListenerDemo();
    }
    private void prepareGUI(){
        mainFrame = new JFrame("Java SWING Examples");

        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create panel and set layout
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        //add elements to panel
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);

    }

    private void showActionListenerDemo(){

        //set label
        headerLabel.setText("Listener in action: ActionListener");

        //create a inner panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.magenta);
        JButton okButton = new JButton("OK");
        okButton.setActionCommand("command");

        //add the listen to the button
        okButton.addActionListener(new CustomActionListener()); //<-- here i set the link to the event handler
        //listener supported for each swing element: https://docs.oracle.com/javase/tutorial/uiswing/events/eventsandcomponents.html
        //okButton.addMouseListener(new CustomMouseListener());

        //add button to the panel
        panel.add(okButton);

        //add inner panel to root panel
        controlPanel.add(panel);

        //set size root panel
        mainFrame.pack();

        //set visibility root panel
        mainFrame.setVisible(true);
    }

    //listener, inner class
    class CustomActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            statusLabel.setText("Button Clicked.");
            System.out.println(e.getActionCommand());
        }
    }

    //listener, inner class
    class CustomMouseListener implements MouseListener {
        public void mouseClicked(MouseEvent e)
        {
            statusLabel.setText("Mouse Clicked: ("+e.getX()+", "+e.getY() +")");
        }
        public void mousePressed(MouseEvent e)
        {
            statusLabel.setText("Mouse pressed.");
        }
        public void mouseReleased(MouseEvent e)
        {
            statusLabel.setText("Mouse released.");
        }
        public void mouseEntered(MouseEvent e)
        {
            statusLabel.setText("Mouse entered.");
        }

        public void mouseExited(MouseEvent e)
        {
            statusLabel.setText("Mouse exit.");
        }
    }

}
