package edu.westga.cs1302.project2.model;

import java.util.ArrayList;

/**
 * Store information for a recipe
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class Recipe {
	private String name;
	private ArrayList<Ingredient> ingredientList;

	/**
	 * Creates a empty recipe
	 * 
	 * @precondition name != null, !name.isEmpty(), !name.isBlank()
	 * @postcondition none
	 * 
	 * @param name the name of the recipe
	 */
	public Recipe(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannont be null.");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name cannont be empty.");
		}
		if (name.isBlank()) {
			throw new IllegalArgumentException("Name cannont be blank.");
		}
		this.name = name;
		this.ingredientList = new ArrayList<Ingredient>();
	}

	/**
	 * Gets the recipe name
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the recipe
	 */
	public String getRecipeName() {
		return this.name;
	}

	/**
	 * Adds the ingredient to the recipe
	 * 
	 * @precondition ingredient != null
	 * @postcondition ingredient is added to the list of ingredients in the
	 *                ingredientList
	 * 
	 * @param ingredient the ingredient to be added to the recipe
	 */
	public void addIngredient(Ingredient ingredient) {
		if (ingredient == null) {
			throw new IllegalArgumentException("ingredient cannot be null.");
		}
		if (this.name.equals(ingredient.getName())) {
			throw new IllegalArgumentException("Ingredient name and recipe name cannot be the same");
		}

		this.ingredientList.add(ingredient);
	}

	/**
	 * Return the ingredients in the recipe
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the ingredients in the recipe
	 */
	public Ingredient[] getItems() {
		return this.ingredientList.toArray(new Ingredient[this.ingredientList.size()]);
	}
}
