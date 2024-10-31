package edu.westga.cs1302.project2.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Writes the recipe to a file
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class RecipeWriteToFile {
	public static final String DATA_FILE = "data.txt";

	/**
	 * Creates an instance of RecipeWriteToFile
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public RecipeWriteToFile() {
		
	}
	
	/**
	 * Wipes the file for storing recipes
	 * 
	 * Erases all recipes in the file
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @throws IOException invalid or missing name/type found when trying to write
	 *                     to a file
	 */
	public void wipeFile() throws IOException {
		try (FileWriter writer = new FileWriter(DATA_FILE)) {
			writer.write("");

		}
	}

	/**
	 * appends the given recipe to the end of the file
	 * 
	 * @precondition recipe != null, recipe.getItems().length != 0
	 * @postcondition none
	 * 
	 * @throws IOExcepion when there is already a recipe with the same name
	 * @throws FileNotFoundException when file does not exists
	 * 
	 * @param recipe the recipe to append
	 */
	public void appendFile(Recipe recipe) throws IOException, FileNotFoundException {
		if (recipe == null) {
			throw new IllegalArgumentException("recipe cannont be null");
		}
		if (recipe.getItems().length == 0) {
			throw new IllegalArgumentException("Cannot have a recipe with no ingredients");
		}

		File inputFile = new File(DATA_FILE);
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		try (Scanner reader = new Scanner(inputFile)) {
			while (reader.hasNextLine()) {
				String recipeName = reader.nextLine().strip();
				if (recipe.getRecipeName().equals(recipeName)) {
					throw new IllegalStateException("Identical recipe already exists");
				}
				Recipe oldRecipe = new Recipe(recipeName);
				String[] ingredients = reader.nextLine().strip().split(",");
				for (int place = 0; place < ingredients.length; place += 2) {
					String ingredientName = ingredients[place];
					String type = ingredients[place + 1];
					Ingredient ingredient = new Ingredient(ingredientName, type);
					oldRecipe.addIngredient(ingredient);
				}
				recipes.add(oldRecipe);
			}
		} catch (IllegalStateException stateError) {
			throw new IOException(stateError.getMessage());
		} 
		recipes.add(recipe);
		try (FileWriter writer = new FileWriter(DATA_FILE)) {
			for (Recipe currentRecipe : recipes) {
				writer.write(Utility.recipeStringFormat(currentRecipe) + System.lineSeparator());
			}
		}
	}

}
