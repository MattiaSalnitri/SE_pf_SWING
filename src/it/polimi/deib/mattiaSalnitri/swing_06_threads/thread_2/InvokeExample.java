package it.polimi.deib.mattiaSalnitri.swing_06_threads.thread_2;

/*
Java Swing, 2nd Edition
By Marc Loy, Robert Eckstein, Dave Wood, James Elliott, Brian Cole
ISBN: 0-596-00408-7
Publisher: O'Reilly
*/
// InvokeExample_thread.java
//This class demonstrates several examples of how to handle long-running
//tasks (such as querying a remote resource). Some of the examples are
//good, some are not!
//

import it.polimi.deib.mattiaSalnitri.swing_06_threads.progressBar.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvokeExample {

    //
    private JButton good = new JButton("Good");
    private JButton bad = new JButton("Bad");
    private JButton bad2 = new JButton("Bad2");
    private JButton print = new JButton("print");

    private JLabel resultLabel = new JLabel("Ready", JLabel.CENTER);

    private BlankWorker_doNothing blankWorker;

    static InvokeExample invokeExample;

    public static void main(String[] args) {

        //adds the creation of frame in the EDT
        SwingUtilities.invokeLater(new Runnable() {//implements a thread with runnable
            @Override
            public void run()
            {
                invokeExample = new InvokeExample();
            }
        });

    }

    public InvokeExample()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout . . .
        JPanel p = new JPanel();
        p.setOpaque(true);
        p.setLayout(new FlowLayout());
        p.add(good);
        p.add(bad);
        p.add(bad2);
        p.add(print);


        f.setLayout(new BorderLayout());
        f.add(p, BorderLayout.CENTER);
        f.add(resultLabel, BorderLayout.SOUTH);


        // Listeners
        good.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev)
            {
                System.out.println("button clicked");

                resultLabel.setText("Working . . .");
                setEnabled(false);

                blankWorker = new BlankWorker_doNothing(resultLabel, invokeExample);

                blankWorker.execute();

            }
        });


        print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {

                System.out.println("print");


            }
        });

        bad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                resultLabel.setText("Working . . .");
                setEnabled(false);

                // We're going to do the same thing, but not in a separate
                // thread.
                try {
                    Thread.sleep(5000); // Dispatch thread is starving!
                } catch (InterruptedException ex) {
                }

                // Report the result.
                resultLabel.setText("Ready");
                setEnabled(true);
            }
        });

        bad2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                resultLabel.setText("Working . . . ");
                setEnabled(false);

                // The wrong way to use invokeLater(). The runnable() shouldn't
                // starve the dispatch thread.
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(5000); // Dispatch thread is starving!
                        } catch (InterruptedException ex) {
                        }

                        resultLabel.setText("Ready");
                        setEnabled(true);
                    }
                });
            }
        });

        f.setSize(300, 100);
        f.setVisible(true);
    }

    // Allows us to turn the buttons on or off while we work.
    public void setEnabled(boolean b) {
        good.setEnabled(b);
        bad.setEnabled(b);
        bad2.setEnabled(b);
    }
}
