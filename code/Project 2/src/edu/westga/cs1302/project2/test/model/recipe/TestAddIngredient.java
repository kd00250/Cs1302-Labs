package edu.westga.cs1302.project2.test.model.recipe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;

class TestAddIngredient {

	@Test
	void testAddNullIngredient() {
		Recipe recipe = new Recipe("Cheese");

		assertThrows(IllegalArgumentException.class, () -> {
			recipe.addIngredient(null);
		});
	}

	@Test
	void testAddSameIngredientNameAsRecipe() {
		Recipe recipe = new Recipe("Cheese");
		Ingredient ingredient = new Ingredient("Cheese", "Dairy");

		assertThrows(IllegalArgumentException.class, () -> {
			recipe.addIngredient(ingredient);
		});
	}

	@Test
	void testAddOneIngredient() {
		Recipe recipe = new Recipe("Steak");
		Ingredient ingredient = new Ingredient("apple", "Fruit");
		recipe.addIngredient(ingredient);

		assertEquals(1, recipe.getItems().length);
		assertEquals(ingredient, recipe.getItems()[0]);
	}

	@Test
	void testAddTwoIngredient() {
		Recipe recipe = new Recipe("Steak");
		Ingredient ingredient1 = new Ingredient("apple", "Fruit");
		Ingredient ingredient2 = new Ingredient("Carrot", "Vegetable");
		recipe.addIngredient(ingredient1);
		recipe.addIngredient(ingredient2);

		assertEquals(2, recipe.getItems().length);
		assertEquals(ingredient1, recipe.getItems()[0]);
		assertEquals("apple", recipe.getItems()[0].getName());
		assertEquals("Fruit", recipe.getItems()[0].getType());
		assertEquals(ingredient2, recipe.getItems()[1]);
		assertEquals("Carrot", recipe.getItems()[1].getName());
		assertEquals("Vegetable", recipe.getItems()[1].getType());
	}

}
