package edu.westga.cs1302.project2.model;

/**
 * The Utility class
 * 
 * @author CS 1302
 * @version fall 2024
 */
public class Utility {

	/**
	 * turns a recipe into string format
	 * 
	 * @precondition recipe != null
	 * @postcondition none
	 * 
	 * @param recipe the recipe to convert to string format
	 * @return the recipe in string format
	 */
	public static String recipeStringFormat(Recipe recipe) {
		if (recipe == null) {
			throw new IllegalArgumentException("Recipe cannot be null.");
		}
		String recipeString = recipe.getRecipeName() + System.lineSeparator();
		for (Ingredient currentItem : recipe.getItems()) {
			recipeString += currentItem.getName() + "," + currentItem.getType() + ",";
		}
		return recipeString.substring(0, recipeString.length() - 1);
	}
}
