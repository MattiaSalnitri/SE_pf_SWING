package it.polimi.deib.mattiaSalnitri.swing_06_threads.thread_2;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class BlankWorker_doNothing extends SwingWorker<Integer, String>
{

    private JLabel resultLabel;
    private  InvokeExample invokeExample;


    public BlankWorker_doNothing(JLabel resultLabel, InvokeExample invokeExample)
    {
        this.resultLabel=resultLabel;
        this.invokeExample=invokeExample;
    }

    @Override
    protected Integer doInBackground() throws Exception
    {
        System.out.println("thread started");

        // Something that takes a long time . . . in real life,
        // this
        // might be a DB query, remote method invocation, etc.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }

        System.out.println("thread ended");

        return 1;
    }

    @Override
    protected void done() {
        resultLabel.setText("Ready");
        invokeExample.setEnabled(true);

        super.done();
    }

    @Override
    protected void process(final List<String> chunks) {
        // Messages received from the doInBackground() (when invoking the publish() method)
    }

}