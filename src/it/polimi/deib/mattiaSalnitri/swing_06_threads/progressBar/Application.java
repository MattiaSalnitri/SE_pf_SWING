package it.polimi.deib.mattiaSalnitri.swing_06_threads.progressBar;

/**
 * simplified version of
 * https://github.com/javacreed/swing-worker-example
 */

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker.StateValue;

public class Application extends JFrame {

    private Action searchCancelAction;


    private JProgressBar searchProgressBar;

    private BlankWorker blankWorker;

    public Application() {
        initActions();
        initComponents();
    }

    private void cancel() {
        blankWorker.cancel(true);
    }

    private void initActions() {
        searchCancelAction = new AbstractAction("Search") {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (blankWorker == null) {
                    search();
                } else {
                    cancel();
                }
            }
        };
    }

    private void initComponents()
    {
        //set the layout
        setLayout(new BorderLayout());

        searchProgressBar = new JProgressBar();
        searchProgressBar.setStringPainted(true);
        searchProgressBar.setVisible(false);

        //add progress bar
        add(searchProgressBar,BorderLayout.NORTH);

        //add button and set the listener
        add(new JButton(searchCancelAction), BorderLayout.SOUTH);
    }

    private void search() {

        //create the progressBar
        blankWorker = new BlankWorker();

        //addPropertyChangeListener is a lister for the progressBar
        blankWorker.addPropertyChangeListener(event -> { // lambda expression
            switch (event.getPropertyName()) {
                case "progress":
                    searchProgressBar.setIndeterminate(false);
                    searchProgressBar.setValue((Integer) event.getNewValue());
                    break;
                case "state":
                    switch ((StateValue) event.getNewValue()) {
                        case DONE:
                            searchProgressBar.setVisible(false);
                            searchCancelAction.putValue(Action.NAME, "Search");
                            blankWorker = null;
                            break;
                        case STARTED:
                        case PENDING:
                            searchCancelAction.putValue(Action.NAME, "Cancel");
                            searchProgressBar.setVisible(true);
                            searchProgressBar.setIndeterminate(true);
                            break;
                    }
                    break;
            }
        });
        blankWorker.execute();
    }
}