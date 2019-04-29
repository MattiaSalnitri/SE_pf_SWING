package it.polimi.deib.mattiaSalnitri.swing_03_containers;

// Java Program to create a horizontal JSplitPane
// to separate two text areas
import javax.swing.*;
class JsplitPane_example extends JFrame {

    // frame
    static JFrame f;

    // text areas
    static JTextArea t1, t2;

    // main class
    public static void main(String[] args)
    {
        // create a new frame
        f = new JFrame("frame");

        // create a object
        JsplitPane_example s = new JsplitPane_example();

        // create a panel
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        // create text areas
        t1 = new JTextArea(10, 10);
        t2 = new JTextArea(10, 10);

        // set texts
        t1.setText("this is first text area");
        t2.setText("this is second text area");

        // add text area to panel
        p1.add(t1);
        p2.add(t2);

        // create a splitpane
        JSplitPane sl = new JSplitPane(SwingConstants.HORIZONTAL, p1, p2);

        // add panel
        f.add(sl);

        // set the size of frame
        f.setSize(300, 300);

        f.show();
    }
}
