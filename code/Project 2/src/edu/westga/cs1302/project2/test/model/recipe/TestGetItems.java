package edu.westga.cs1302.project2.test.model.recipe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;

class TestGetItems {

	@Test
	void testNoItems() {
		Recipe recipe = new Recipe("Steak");

		assertEquals(0, recipe.getItems().length);
	}

	@Test
	void testOneItem() {
		Recipe recipe = new Recipe("Steak");
		Ingredient item1 = new Ingredient("Apple", "Fruit");
		recipe.addIngredient(item1);

		assertEquals(1, recipe.getItems().length);
		assertEquals(item1, recipe.getItems()[0]);
		assertEquals(item1.getName(), recipe.getItems()[0].getName());
		assertEquals(item1.getType(), recipe.getItems()[0].getType());
	}

	@Test
	void testMultipleItems() {
		Recipe recipe = new Recipe("Steak");
		Ingredient item1 = new Ingredient("Apple", "Fruit");
		Ingredient item2 = new Ingredient("Cheese", "Dairy");
		recipe.addIngredient(item1);
		recipe.addIngredient(item2);

		assertEquals(2, recipe.getItems().length);
		assertEquals(item1, recipe.getItems()[0]);
		assertEquals(item1.getName(), recipe.getItems()[0].getName());
		assertEquals(item1.getType(), recipe.getItems()[0].getType());
		assertEquals(item2, recipe.getItems()[1]);
		assertEquals(item2.getName(), recipe.getItems()[1].getName());
		assertEquals(item2.getType(), recipe.getItems()[1].getType());
	}

}
