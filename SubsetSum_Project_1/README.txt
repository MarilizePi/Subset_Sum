project folder:
MarilizePi-cs1c-project02

Brief description of submitted files:

src/cs1c/MillionSongDataSubset.java
    - Parses a JSON data set and stores each entry in an array.

src/cs1c/SongEntry.java
    - Stores a simplified version of the genre data set from the Million Song Dataset.

src/cs1c/TimeConverter.java
    - Converts duration into a string representation.


src/subsetsum/FoothillTunesStore.java
    - Reads an input file that contains the prices of the different items.
    - Includes main.

src/subsetsum/GroceriesFileReader.java
    - Read the input file that contains the prices of different items.

src/subsetsum/ShoppingBag.java
    - An object of type ShoppingBag class creates an object of type subset sum to find a best
    possible grocery shopping list within the given budget.
    - Includes main.

src/subsetsum/SubsetSum.java
    - Subset sum is an algorithm to find the subset of elements in a given list,
    whose sum equals a given specified number.
    - The class SubsetSum will loop over a given grocery list (or song list) and check if the sum of its elements
     will equal the user input. It will return the closest match.

-----

resources/groceries.txt
    - A list of groceries items and their prices that will be tested by SubsetSum.java,
    and printed by ShoppingBag.java.

resources/groceries2.txt
    - A second list of groceries items and their prices that will be tested by SubsetSum.java,
    and printed by ShoppingBag.java.

resources/groceries3.txt
    - A third list of groceries items and their prices that will be tested by class SubsetSum,
    and printed by ShoppingBag.

resources/music_genre_subset.json
    - Contains songs in a JSON format.

resources/RUN.txt
    - Console outputs the run for grocery list (shoppingBag.java) as well as songs (FoothillTunesStore.java).

-----

.gitignore
    - .gitignore content tells git to ignore specified files or folder.

-----

README.txt
    - Description of submitted files.