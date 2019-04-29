package it.polimi.deib.mattiaSalnitri.swing_08_esBancarella;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * implements a thread for the customer
 */
public class Customer
{

    public Customer(FruitHandler fh, JLabel tomatosQL, JLabel potatosQL, JLabel basilsQL )
    {

        Thread customerConsume = new Thread() {
            public void run() {

                while (true)
                {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //chose a type to consume
                    int type = ThreadLocalRandom.current().nextInt(0, 2 + 1);

                    switch (type){
                        case 0:
                            basilsQL.setText(fh.getBasil().toString());
                            System.out.println("consumed Basil");
                            break;
                        case 1:
                            tomatosQL.setText(fh.getTomato().toString());
                            System.out.println("consumed Tomato");
                            break;
                        case 2:
                            potatosQL.setText(fh.getPotato().toString());
                            System.out.println("consumed Potato");
                            break;
                    }

                }


            }
        };

        customerConsume.start();


    }
}
