/*
 * Generic ship class
 */
package navydemo;

/**
 *
 * @author ayeletbuchen
 */
public class Ship implements Comparable{

    private String name;
    private int year;

    /**
     * Create a ship with a name and a year that it was built
     *
     * @param nm
     * @param yr
     */
    public Ship(String nm, int yr)
    {
        name = nm;
        year = yr;
    }

    /**
     *
     * @return the ship's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the ship's name
     *
     * @param nm
     */
    public void setName(String nm)
    {
        name = nm;
    }

    /**
     *
     * @return the year that the ship was built
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Set the year that the ship was built
     *
     * @param yr
     */
    public void setYear(int yr)
    {
        year = yr;
    }

    /**
     *
     * @return String of the ship's name and year it was built
     */
    @Override
    public String toString()
    {
        return ("SHIP\t\tName: " + name + "\t\tYear: " + year);
    }

    /**
     * Compare two ships by age
     * 
     * @param ship the ship to be compared with the current ship
     * @return the difference in age between the two ships
     */
    @Override
    public int compareTo(Object ship)
    {
        int difference = 0;
        if (ship instanceof Ship)
        {
            difference = year - ((Ship) ship).getYear();
        }
        return difference;
    }
}