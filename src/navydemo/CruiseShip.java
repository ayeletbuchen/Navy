/*
 * Cruise Ship Class
 */
package navydemo;

/**
 *
 * @author ayeletbuchen
 */
public class CruiseShip extends Ship implements Comparable {

    private int maxPassengers;

    /**
     * Create a cruise ship, a type of ship with a name, year, and maximum
     * number of passengers
     *
     * @param nm
     * @param yr
     * @param max
     */
    public CruiseShip(String nm, int yr, int max)
    {
        super(nm, yr);
        maxPassengers = max;
    }

    /**
     *
     * @return the maximum number of passengers
     */
    public int getMaxPassengers()
    {
        return maxPassengers;
    }

    /**
     * Set the maximum number of passengers
     *
     * @param max
     */
    public void setMaxPassengers(int max)
    {
        maxPassengers = max;
    }

    /**
     *
     * @return String of ship's name, year, and maximum number of passengers
     */
    @Override
    public String toString()
    {
        return ("CRUISE " + super.toString() + "\t\tMaximum Number of "
                + "Passengers: " + maxPassengers);
    }

    /**
     * Compare two cruise ships by the maximum number of passengers
     * If you want to compare the CruiseShips by age instead, then simply
     * comment out this method, and the super compareTo will be called
     *
     * @param ship must be of type Object in order to Override compareTo()
     * method in Comparable
     * @return the difference between maxPassengers of each ship
     */
    @Override
    public int compareTo(Object ship)
    {   
        int difference;
        if (ship instanceof CruiseShip)
        {
            int otherMax = ((CruiseShip) ship).getMaxPassengers();
            difference = maxPassengers - otherMax;
        }
        else
        {
            difference = super.compareTo(ship);
        }
        return difference;
    }
}