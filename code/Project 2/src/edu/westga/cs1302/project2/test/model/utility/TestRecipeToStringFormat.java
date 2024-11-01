package edu.westga.cs1302.project2.test.model.utility;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.Utility;

class TestRecipeToStringFormat {

	@Test
	void testNullRecipe() {
		assertThrows(IllegalArgumentException.class, () -> {
			Utility.recipeStringFormat(null);
		});
	}

	@Test
	void testOneItem() throws IOException {
		Recipe recipe = new Recipe("Steak");
		Ingredient item = new Ingredient("Apple", "Fruit");
		recipe.addIngredient(item);

		assertEquals("Steak" + System.lineSeparator() + "Apple,Fruit", Utility.recipeStringFormat(recipe));

	}

	@Test
	void testMultipleItems() throws IOException {
		Recipe recipe = new Recipe("Steak");
		Ingredient item1 = new Ingredient("Apple", "Fruit");
		Ingredient item2 = new Ingredient("Cheese", "Dairy");
		recipe.addIngredient(item1);
		recipe.addIngredient(item2);

		assertEquals("Steak" + System.lineSeparator() + "Apple,Fruit,Cheese,Dairy", Utility.recipeStringFormat(recipe));
	}

}
