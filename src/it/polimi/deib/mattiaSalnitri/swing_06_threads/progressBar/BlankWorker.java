package it.polimi.deib.mattiaSalnitri.swing_06_threads.progressBar;

/**
 * simplified version of
 * https://github.com/javacreed/swing-worker-example
 */

import java.util.List;

import javax.swing.SwingWorker;

public class BlankWorker extends SwingWorker<Integer, String>
    // two generics fro the swingWorker
    //The first one represents the type of object returned when the worker has finished working.
    //The second one represents the type of information that the worker will use to inform (update) the application with its progress.
{

    @Override
    protected Integer doInBackground() throws Exception {//that's a simulation for a (very) long task
        // Start
        publish("Start");
        setProgress(1);//set the progress of the task, this is not linked with the generics

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }

        // More work was done
        publish("More work was done");
        setProgress(50);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }

        // Complete
        publish("Complete");
        setProgress(100);
        return 1;
    }

    @Override
    protected void process(final List<String> chunks) {
        // Messages received from the doInBackground() (when invoking the publish() method)
    }

}