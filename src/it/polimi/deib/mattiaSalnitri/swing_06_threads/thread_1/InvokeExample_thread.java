package it.polimi.deib.mattiaSalnitri.swing_06_threads.thread_1;

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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class InvokeExample_thread {

    //
    private static JButton good = new JButton("Good");
    private static JButton bad = new JButton("Bad");
    private static JButton bad2 = new JButton("Bad2");
    private static JButton print = new JButton("print");

    private static JLabel resultLabel = new JLabel("Ready", JLabel.CENTER);

    public static void main(String[] args) {
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
            public void actionPerformed(ActionEvent ev) {
                resultLabel.setText("Working . . .");
                setEnabled(false);

                // We're going to do something that takes a long time, so we
                // spin off a thread and update the display when we're done.
                Thread worker = new Thread() {
                    public void run() {
                        // Something that takes a long time . . . in real life,
                        // this
                        // might be a DB query, remote method invocation, etc.
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException ex) {
                        }

                        // Report the result using invokeLater().
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                resultLabel.setText("Ready");
                                setEnabled(true);
                            }
                        });
                    }
                };

                worker.start(); // So we don't hold up the dispatch thread.
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
    static void setEnabled(boolean b) {
        good.setEnabled(b);
        bad.setEnabled(b);
        bad2.setEnabled(b);
    }
}
