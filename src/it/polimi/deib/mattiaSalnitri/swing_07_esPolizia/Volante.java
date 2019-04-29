package it.polimi.deib.mattiaSalnitri.swing_07_esPolizia;

/**
 * class that manages a volante
 */
public class Volante
{
    private String name;
    private int numAgent;

    /**
     *  comntructuor of the class
     * @param name name of the volante
     * @param numAgent numnber of agents on the volante
     */
    public Volante (String name, int numAgent)
    {
        this.name = name;
        this.numAgent = numAgent;
    }


    public String getName() {
        return name;
    }

    public int getNumAgent() {
        return numAgent;
    }

}
