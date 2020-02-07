package subsetsum;

import java.io.*;
import java.util.*;

/**
 * GroceriesFileReader read the input file that contains the prices of different items.
 */
public class GroceriesFileReader {

    /**
     *  readFile reads CSV files of groceries, creates a specified ArrayList of grocery prices and adds values to it.
     * @param filePath the JSON file.
     * @return price of grocery list.
     */
    public ArrayList<Double> readFile(String filePath) {

        //ArrayList for each price.
        ArrayList<Double> groceryPrice = new ArrayList<>();

        //Input from user. Attempt to parse a value.
        try {
            Scanner scanner = new Scanner(new File(filePath));

            while (scanner.hasNext()) {
                String items = scanner.next();
                String[] tokens = items.split(",");

                double price = (Double.parseDouble(tokens[1]));
                groceryPrice.add(price);
            }
            scanner.close();
            //If input is not found, catch will display an error message.
        } catch (FileNotFoundException e) {
            System.out.println("List not found");
        }
        return groceryPrice;
    }
}
