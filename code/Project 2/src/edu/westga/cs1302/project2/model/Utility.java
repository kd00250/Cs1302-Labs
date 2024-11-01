package edu.westga.cs1302.project2.model;

import java.util.ArrayList;

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

	/**
	 * Takes a list and turns it into string format
	 * 
	 * @precondition recipes != null
	 * @postcondition none
	 * 
	 * @param recipes the list of recipes
	 * @return the list of recipes in string format
	 */
	public static String recipeListToString(ArrayList<Recipe> recipes) {
		if (recipes == null) {
			throw new IllegalArgumentException("Recipes cannot be null");
		}

		String recipeList = "";
		for (Recipe currentRecipe : recipes) {
			recipeList += recipeStringFormat(currentRecipe) + System.lineSeparator() + System.lineSeparator();
		}
		return recipeList;
	}
}
