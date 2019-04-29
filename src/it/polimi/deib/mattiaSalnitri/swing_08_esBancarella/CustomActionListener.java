package it.polimi.deib.mattiaSalnitri.swing_08_esBancarella;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * execute the actuons of the buttons
 */
public class CustomActionListener implements ActionListener
{
    FruitHandler fh;
    JLabel label;
    String type;

    public CustomActionListener(FruitHandler fh, String type, JLabel label)
    {
        this.fh = fh;
        this.label = label;
        this.type = type;

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (type){
            case "tomato": label.setText(fh.addTomato().toString());
                break;
            case "basil": label.setText(fh.addBasil().toString());
                break;
            case "potato": label.setText(fh.addPotato().toString());
                break;
        }

    }



}
