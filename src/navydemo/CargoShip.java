/*
 * Cargo Ship class
 */
package navydemo;

/**
 *
 * @author ayeletbuchen
 */
public class CargoShip extends Ship implements Comparable {

    private int cargoCapacity;

    /**
     * Create a cargo ship with a name, year, and cargo capacity
     *
     * @param nm
     * @param yr
     * @param capacity
     */
    public CargoShip(String nm, int yr, int capacity)
    {
        super(nm, yr);
        cargoCapacity = capacity;
    }

    /**
     *
     * @return the cargo capacity
     */
    public int getCargoCapacity()
    {
        return cargoCapacity;
    }

    /**
     * Set the cargo capacity
     *
     * @param capacity
     */
    public void setCargoCapacity(int capacity)
    {
        cargoCapacity = capacity;
    }

    /**
     *
     * @return a String of the ship's name, year built, and cargo capacity
     */
    @Override
    public String toString()
    {
        return ("CARGO " + super.toString() + "\t\tCargo Capacity: "
                + cargoCapacity);
    }

    /**
     * Compare two cargo ships by cargo capacity
     *
     * @param ship must be of type Object in order to Override compareTo()
     * method in Comparable
     * @return the difference between the cargo capacities of the two ships
     */
    @Override
    public int compareTo(Object ship)
    {
        int difference;
        if (ship instanceof CargoShip)
        {
            int otherCapacity = ((CargoShip) ship).getCargoCapacity();
            difference = cargoCapacity - otherCapacity;
        }
        else
        {
            difference = super.compareTo(ship);
        }
        return difference;
    }
}