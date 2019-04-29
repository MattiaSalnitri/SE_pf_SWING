package it.polimi.deib.mattiaSalnitri.swing_07_esPolizia;

import java.util.Vector;

/**
 * class that manages a set of volanti in different zones
 */
public class VolanteManager
{
    private Vector<Volante> volanti1;
    private Vector<Volante> volanti2;
    private Vector<Volante> volanti3;
    private Vector<Volante> volanti4;
    private Vector<Volante> volanti5;
    private Vector<Volante> volanti6;

    /**
     * constructor of the class
     */
    public VolanteManager()
    {
        volanti1 = new Vector<Volante>();
        volanti2 = new Vector<Volante>();
        volanti3 = new Vector<Volante>();
        volanti4 = new Vector<Volante>();
        volanti5 = new Vector<Volante>();
        volanti6 = new Vector<Volante>();
    }

    /**
     * add a volante in a specified zone
     *
     * @param volante the volante to add
     * @param zone the zone where the volante is placed
     */
    public void addVolante (Volante volante, int zone)
    {
        switch(zone) {
            case 1:
                volanti1.add(volante);
                break;
            case 2:
                volanti2.add(volante);
                break;
            case 3:
                volanti3.add(volante);
                break;
            case 4:
                volanti4.add(volante);
                break;
            case 5:
                volanti5.add(volante);
                break;
            default:
                volanti6.add(volante);
        }


    }

    /**
     * returns the volanti in a specified zone
     *
     * @param zone the zone to search
     * @return the collection of volanti in the specified zone
     */
    public Vector<Volante> getVolantiZone(int zone)
    {
        switch(zone) {
            case 1:
                return volanti1;
            case 2:
                return volanti2;
            case 3:
                return volanti3;
            case 4:
                return volanti4;
            case 5:
                return volanti5;
            default:
                return volanti6;
        }
    }
}
