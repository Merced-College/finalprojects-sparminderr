// Parminder Singh
// 4/21/26

import java.util.*;
public class Inventory {

    // creates a list to store items
    ArrayList<String> items = new ArrayList<>();

    // handles when you add an itemand prints out a message showing you did
    public void addItem(String item) {
        items.add(item);
        System.out.println(item + " added!");
    }

    // shows all the items you have and prints them
    public void showItems() {
        System.out.println("Inventory: " + items);
    }

    // linear search algorithm: checks if items exists and loops through each item in the list. 
    // compares each item to the one you want and returns a true/false when found or not
    // time complexity: O(n)
    public boolean hasItem(String item) {
        for (String i : items) {
            if (i.equals(item)) 
                return true;
        }
        return false;
    }

    // sorting algorithm: sorts the list alphabetically, uses inbuild timSort 
    public void sortItems() {
        Collections.sort(items);
    }
}