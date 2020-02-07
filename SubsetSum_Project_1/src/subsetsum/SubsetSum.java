package subsetsum;

import cs1c.SongEntry;

import java.util.*;

/**
 * Subset sum is an algorithm to find the subset of elements in a given list,
 * whose sum equals a given specified number.
 * The class SubsetSum will loop over a given grocery list (or song list)
 * and check if the sum of its elements will equal the user input.
 * It will return the closest match.
 *
 * @author Pires, Marilize
 */

public class SubsetSum {

    //Initialize collection of subsets and empty list for grocery list.
    static ArrayList<ArrayList<Double>> listOfGroceries = new ArrayList<>();
    static ArrayList<Double> subListGroceries = new ArrayList<>();

    //Initialize collection of subsets and empty list for song list.
    static ArrayList<ArrayList<SongEntry>> listOfSongs = new ArrayList<>();
    static ArrayList<SongEntry> subListSongs = new ArrayList<>();

    //Class constant
    public static final int INDEX = 0;

    /**
     * Given all the subsets in the collection, FindSubset will return the closest match value (sum).
     *
     * @param groceryList arrayList that stores the grocery prices.
     * @param budget      a double that symbolizes the target (budget) amount.
     * @return given the user input (budget), closestMatchToBudget will return the closest match (sum).
     */
    public static ArrayList<Double> findSubset(ArrayList<Double> groceryList, double budget) {

        //Adds a new sublist to the collection of subsets.
        listOfGroceries.add(subListGroceries);

        //ArrayList to find the match for the target value (budget).
        ArrayList<Double> closestMatchToBudget = new ArrayList<>();

        //Checks to see if user input is higher that the total sum of given elements from grocery list.
        //If true, it will return the the grocery list.
        if (budget >= sumOfAllElements(groceryList)) {
            System.out.println("Your budget exceeds the total sum of grocery list. You can buy them all!");
            return groceryList;
            // It will check if the user budget is high enough to buy the items.
            // If true, it will return the closest match/sum to the user input (budget).
        } else {
            for (int i = 0; i < groceryList.size(); i++) {
                int size = listOfGroceries.size();
                int indexNumber = 0;

                while (indexNumber < size) {
                    ArrayList<Double> currentSubset = listOfGroceries.get(indexNumber);

                    double sum = sumOfAllElements(currentSubset) + groceryList.get(i);

                    //Checks sum against target value. If true, it will add the sublist to collection.
                    if (sum < budget) {
                        ArrayList<Double> subset = new ArrayList<>();

                        for (int k = 0; k < currentSubset.size(); k++) {
                            subset.add(currentSubset.get(k));
                        }
                        //It will add the index as a new element.
                        subset.add(groceryList.get(i));
                        listOfGroceries.add(subset);

                        if (sum == budget) {
                            return subset;
                        } else if (sumOfAllElements(closestMatchToBudget) < sum) {
                            closestMatchToBudget = subset;
                        }
                    }
                    indexNumber++;
                }
            }
        }
        return closestMatchToBudget;
    }

    /**
     * Given all the subsets in the collection, findSubsetOfSongs will return the closest match duration (sum).
     *
     * @param songList arrayList for the songs duration.
     * @param duration a double that symbolizes the the target (duration) amount.
     * @return given the user input (duration), it will return the closes match (sum).
     */
    public static ArrayList<SongEntry> findSubsetOfSongs(ArrayList<SongEntry> songList, double duration) {

        //Adds a new sublist to collection of subsets.
        listOfSongs.add(subListSongs);

        ArrayList<SongEntry> closestMatchToBudget = new ArrayList<>();

        if (duration > sumOfAllElements(songList)) {
            return songList;
        } else {
            for (int i = 0; i < songList.size(); i++) {
                Iterator<ArrayList<SongEntry>> songListIterator = listOfSongs.iterator();

                while (songListIterator.hasNext()) {
                    ArrayList<SongEntry> currentSubset = songListIterator.next();

                    double sum = sumOfAllElements(currentSubset) + (double) songList.get(i).getDuration();
                    //If true, it will add the sublist to the collection.
                    if (sum < duration) {
                        currentSubset.add(songList.get(i));
                    } else if (sumOfAllElements(closestMatchToBudget) < sum) {
                        closestMatchToBudget = currentSubset;
                    }
                }
            }
        }
        return closestMatchToBudget;
    }

    // ---------- HELPER METHOD ----------

    /**
     * Method sumOfAllElements sum all the elements in the original list.
     *
     * @param originalList genetic arrayList that
     * @param <T>          genetic method that stores all the original subset.
     * @return sum of elements, considering the user input.
     */
    public static <T> double sumOfAllElements(ArrayList<T> originalList) {

        double sum = 0.0;

        if (originalList.isEmpty()) {
            return 0.0;
        }

        //Total sum update will check to see if list contains Objects of type Double.
        if (originalList.get(INDEX) instanceof Double) {
            for (int i = 0; i < originalList.size(); i++) {
                sum += (double) originalList.get(i);
            }
            return sum;

            //Total sum update will check to see if list contains SongEntry Objects.
        } else if (originalList.get(INDEX) instanceof SongEntry) {
            ArrayList<SongEntry> songList = (ArrayList<SongEntry>) originalList;

            for (int i = 0; i < originalList.size(); i++) {
                double duration = songList.get(i).getDuration();
                sum = sum + duration;
            }
            return sum;
        }
        return sum;
    }
}