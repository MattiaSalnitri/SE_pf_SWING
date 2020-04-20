package it.polimi.deib.mattiaSalnitri.swing_01;

import javax.swing.*;

/**
 * creates an empty SWING JFrame
 */
public class PrimoJframe {

    public static void main(String[] args)
    {
        //set the lookAndFeel (optional)
        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());//metal -> cross platform, looks the same in all platforms
                    UIManager.getSystemLookAndFeelClassName();// set the default of the platform -> this by default
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame window = new JFrame();

        //set the size of the window
        window.setSize(500,600);

        //set the window visibility to true
        window.setVisible(true);

        //set the behaviour when the window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set the window in the middle of the screen
        window.setLocationRelativeTo(null);

    }

}
