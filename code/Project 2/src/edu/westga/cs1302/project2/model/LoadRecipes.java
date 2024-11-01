package edu.westga.cs1302.project2.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Load Recipes class
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class LoadRecipes {

	/**
	 * Creates an instance of LoadRecipes
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public LoadRecipes() {

	}

	/**
	 * Reads the file
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the recipes in the file in a array list
	 */
	public ArrayList<Recipe> loadFile() {
		File inputFile = new File(RecipeWriteToFile.DATA_FILE);
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		try (Scanner reader = new Scanner(inputFile)) {
			while (reader.hasNextLine()) {
				String recipeName = reader.nextLine().strip();
				Recipe recipe = new Recipe(recipeName);
				String[] ingredients = reader.nextLine().strip().split(",");
				for (int place = 0; place < ingredients.length; place += 2) {
					String ingredientName = ingredients[place];
					String type = ingredients[place + 1];
					Ingredient ingredient = new Ingredient(ingredientName, type);
					recipe.addIngredient(ingredient);
				}
				recipes.add(recipe);
			}
		} catch (FileNotFoundException fileError) {
			return recipes;
		}
		return recipes;
	}

	/**
	 * gets a list of recipes with the same ingredient
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param ingredient the ingredient to search for
	 * @return a arrayList of recipes with the same ingredient
	 */
	public ArrayList<Recipe> getRecipesWithSameIngredient(Ingredient ingredient) {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		for (Recipe currentRecipe : this.loadFile()) {
			for (Ingredient currentIngredient : currentRecipe.getItems()) {
				if (ingredient.getName().equals(currentIngredient.getName())
						&& ingredient.getType().equals(currentIngredient.getType())) {
					recipes.add(currentRecipe);
				}
			}
		}

		return recipes;

	}
}
