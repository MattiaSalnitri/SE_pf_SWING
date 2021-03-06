package it.polimi.deib.mattiaSalnitri.swing_06_threads.progressBar;

/**
 * simplified version of
 * https://github.com/javacreed/swing-worker-example
 */

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(final String[] args)
    {
        //adds the creation of frame in the EDT
        SwingUtilities.invokeLater(new Runnable() {//implements a thread with runnable
            @Override
            public void run() {
                final Application frame = new Application();
                frame.setTitle("Swing Worker Demo");
                frame.setSize(600, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}