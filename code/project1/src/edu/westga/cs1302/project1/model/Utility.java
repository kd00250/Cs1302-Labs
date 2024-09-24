package edu.westga.cs1302.project1.model;

import java.util.ArrayList;

import javafx.scene.control.ListView;

/**
 * Contains static methods used in program
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class Utility {

	/**
	 * Gets the total sum of all quantities in the list view by calling another
	 * method for calculations
	 * 
	 * @precondition non
	 * @postcondition none
	 * 
	 * @param food the list view of food
	 * @return the sum of all quantities in the list view
	 */
	public static int getTotalQuantityOfItems(ListView<PantryItem> food) {
		ArrayList<PantryItem> items = new ArrayList<PantryItem>();
		for (PantryItem currentItem : food.getItems()) {
			items.add(currentItem);
		}
		return getTotalQuantity(items);
	}

	/**
	 * Gets the total sum of all quantities in the list view
	 * 
	 * @precondition !food.isEmpty()
	 * @postcondition none
	 * @throws IllegalArgumentException violates precondition
	 * 
	 * @param food the array list of food
	 * @return the sum of all quantities in the list view
	 */
	public static int getTotalQuantity(ArrayList<PantryItem> food) throws IllegalArgumentException {
		if (food.isEmpty()) {
			throw new IllegalArgumentException("The List cannot be empty.");
		}
		int sum = 0;
		for (PantryItem currentItem : food) {
			sum += currentItem.getQuantity();
		}
		return sum;
	}
}
