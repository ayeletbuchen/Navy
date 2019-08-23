/*
 * Navy with polymorphism
 */
package navydemo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ayeletbuchen
 */
public class NavyDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        introduction();
        ArrayList<Ship> ships = initializeShips();
        System.out.println("---------------------------------------------");
        System.out.println("Here is a list of all ships entered:");
        System.out.println("---------------------------------------------\n");
        displayShips(ships);
        System.out.println("\n---------------------------------------------");
        System.out.println("Here are comparisons between each ship entered:");
        System.out.println("---------------------------------------------\n");
        compareShips(ships);
    }

    private static void introduction()
    {
        String input;
        //Introduce the program to the user
        JOptionPane.showMessageDialog(null, "Let's organize information about "
                + "a collection of ships.");

        //Give user option to enter a ship or to leave the program
        do
        {
            input = JOptionPane.showInputDialog("Would you like to provide "
                    + "information about a ship? (y/n)");
        } while (input.equals(""));

        //If user chooses not to enter even 1 ship, exit
        if (!(input.charAt(0) == 'Y') && !(input.charAt(0) == 'y'))
        {
            JOptionPane.showMessageDialog(null, "Goodbye!");
            System.exit(0);
        }
    }

    /**
     *
     * @return an array with all ships initialized
     */
    private static ArrayList<Ship> initializeShips()
    {
        ArrayList<Ship> ships = new ArrayList<>();

        //While user wants to enter information about another ship, get the
        //information about that ship
        String input;       //to hold user input
        do
        {
            //ask the user what type of ship it is
            String shipType = getShipType();

            //Get the ship's name
            String name = getShipName();

            //Get the year that the ship was built
            int year = getNumericInfo('Y');

            //If user entered a cruise ship, get necessary information and add
            //it to the array
            if (shipType.equalsIgnoreCase("Cruise Ship")
                    || shipType.equalsIgnoreCase("a"))
            {
                //Get maximum number of passengers that the ship can hold
                int max = getNumericInfo('P');

                ships.add(new CruiseShip(name, year, max));
            }

            //If user entered a cruise ship, get necessary information and add
            //the ship to the array
            else if (shipType.equalsIgnoreCase("Cargo Ship")
                    || shipType.equalsIgnoreCase("b"))
            {
                //Get the cargo ship's capacity
                int capacity = getNumericInfo('C');

                ships.add(new CargoShip(name, year,
                        capacity));
            }

            //If user did not enter a cruise or cargo ship
            else
            {
                ships.add(new Ship(name, year));
            }

            //After initializing the ship, ask the user if he wants to enter
            //another ship. If he says yes, the program will go back to the
            //beginning of the loop and ask the user for information about
            //the ship.
            do
            {
                input = JOptionPane.showInputDialog("Would you like to provide "
                        + "information about another ship? (y/n)");
            } while (input.equals(""));
        } while (input.charAt(0) == 'Y' || input.charAt(0) == 'y');
        return ships;
    }

    /**
     *
     * @return the type of ship: either cargo or cruise ship
     */
    private static String getShipType()
    {
        String shipType;
        boolean validCategory = false;  //true if shipType is valid ship

        //Get the type of ship from the user
        do
        {
            shipType = JOptionPane.showInputDialog("Please enter the"
                    + " category of this ship:\n\n"
                    + "a. Cruise Ship\n"
                    + "b. Cargo Ship\n"
                    + "c. Other\n\n");
            if (shipType.equalsIgnoreCase("Cruise Ship")
                    || shipType.equalsIgnoreCase("a")
                    || shipType.equalsIgnoreCase("Cargo Ship")
                    || shipType.equalsIgnoreCase("b")
                    || shipType.equalsIgnoreCase("Other")
                    || shipType.equalsIgnoreCase("c"))
            {
                validCategory = true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid category.");
            }

        } while (!validCategory);
        return shipType;
    }

    /**
     *
     * @return the ship's name
     */
    private static String getShipName()
    {
        String name;
        do
        {
            name = JOptionPane.showInputDialog("What is this ship's name?");
        } while (name.equals(""));
        return name;
    }

    /**
     * @param letter indicating which prompt to ask for
     * @return the year, max passengers, or cargo capacity of the ship
     */
    private static int getNumericInfo(char letter)
    {
        int number;
        String prompt = "";

        switch (letter)
        {
            case 'Y':
                prompt = "In what year was this ship built?";
                break;
            case 'P':
                prompt = "What is the maximum number of passengers that this "
                        + "ship can hold?";
                break;
            case 'C':
                prompt = "In digits, what is the cargo capacity of this ship?";
                break;
        }

        do
        {
            String input = JOptionPane.showInputDialog(prompt);
            //Parse number to make sure input is a year in digits
            number = parseNumber(input);
        } while (number < 0);
        return number;
    }

    /**
     *
     * @param input - the information to be parsed
     * @return parsed number if input was a number. Otherwise, return -1
     */
    private static int parseNumber(String input)
    {
        int number;
        try
        {
            number = Integer.parseInt(input);
            if (number < 0)
            {
                JOptionPane.showMessageDialog(null, "Invalid input.");
            }
        } catch (NumberFormatException exc)
        {
            JOptionPane.showMessageDialog(null, "Invalid input.");
            number = -1;
        }
        return number;
    }

    /**
     * Display sorted information about all of the ships in the array Cruise
     * ships sorted by year built Cargo ships sorted by cargo capacity
     *
     * @param ships
     */
    private static void displayShips(ArrayList<Ship> ships)
    {
        ships.forEach((ship) ->
        {
            System.out.println(ship);
        });
    }

    /**
     * Compare each ship in the array with all the other ships in the array
     * @param ships the array of ships to be compared
     */
    private static void compareShips(ArrayList<Ship> ships)
    {
        for (int ix = 0; ix < ships.size(); ++ix)
        {
            //initialize ii to ix so that any two ships only get compared once
            //i.e., if 9 ships were entered, there should be 45
            //comparisons (9+8+7+6+5+4+3+2+1), not 81 comparisons (9*9)
            for (int ii = ix; ii < ships.size(); ++ii)
            {
                String str;
                Ship ship1 = ships.get(ix);
                Ship ship2 = ships.get(ii);
                
                if (ship1 instanceof CargoShip
                        && ship2 instanceof CargoShip)
                {
                    str = " by cargo capacity: ";
                }
                else if (ship1 instanceof CruiseShip
                        && ship2 instanceof CruiseShip)
                {
                    str = " by maximum number of passengers: ";
                }
                else
                {
                    str = " by age: ";
                }
                System.out.println("Comparing " + ship1.getName()
                        + " and " + ship2.getName()
                        + str + ship1.compareTo(ship2));
            }
        }
    }

}