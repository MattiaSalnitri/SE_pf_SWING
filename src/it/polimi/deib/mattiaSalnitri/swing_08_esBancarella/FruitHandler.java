package it.polimi.deib.mattiaSalnitri.swing_08_esBancarella;

/**
 * manages the fruits ( model)
 */
public class FruitHandler {

    private Integer tomatos = 0;
    private Integer basils = 0;
    private Integer potatos = 0;

    public Integer addTomato()
    {
        return ++tomatos;
    }

    public Integer addBasil()
    {
        return ++basils;
    }

    public Integer addPotato()
    {
        return ++potatos;
    }

    public Integer getTomato()
    {
        if (tomatos==0)
            return 0;
        else
        {
            return --tomatos;
        }

    }

    public Integer getBasil()
    {
        if (basils==0)
            return 0;
        else
        {
            return --basils;
        }

    }

    public Integer getPotato()
    {
        if (potatos==0)
            return 0;
        else
        {
            return --potatos;
        }

    }
}
