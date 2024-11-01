package edu.westga.cs1302.project2.test.model.utility;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.Utility;

class TestRecipeListToString {

	@Test
	void testNullRecipe() {
		assertThrows(IllegalArgumentException.class, () -> {
			Utility.recipeListToString(null);
		});
	}

	@Test
	void testOneItem() throws IOException {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		Recipe recipe = new Recipe("Steak");
		Ingredient item = new Ingredient("Apple", "Fruit");
		recipe.addIngredient(item);
		recipes.add(recipe);

		assertEquals("Steak" + System.lineSeparator() + "Apple,Fruit" + System.lineSeparator() + System.lineSeparator(),
				Utility.recipeListToString(recipes));

	}

	@Test
	void testMultipleItems() throws IOException {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		Recipe recipe = new Recipe("Steak");
		Ingredient item1 = new Ingredient("Apple", "Fruit");
		Ingredient item2 = new Ingredient("Cheese", "Dairy");
		recipe.addIngredient(item1);
		recipe.addIngredient(item2);
		recipes.add(recipe);

		assertEquals("Steak" + System.lineSeparator() + "Apple,Fruit,Cheese,Dairy" + System.lineSeparator()
				+ System.lineSeparator(), Utility.recipeListToString(recipes));
	}

	@Test
	void testMultipleRecipes() throws IOException {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		Recipe recipe = new Recipe("Steak");
		Recipe recipe2 = new Recipe("Cake");
		Ingredient item1 = new Ingredient("Apple", "Fruit");
		Ingredient item2 = new Ingredient("Cheese", "Dairy");
		recipe.addIngredient(item1);
		recipe.addIngredient(item2);
		recipe2.addIngredient(item2);
		recipes.add(recipe);
		recipes.add(recipe2);

		assertEquals("Steak" + System.lineSeparator() + "Apple,Fruit,Cheese,Dairy" + System.lineSeparator()
				+ System.lineSeparator() + "Cake" + System.lineSeparator() + "Cheese,Dairy" + System.lineSeparator()
				+ System.lineSeparator(), Utility.recipeListToString(recipes));
	}
}
