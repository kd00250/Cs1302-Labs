package edu.westga.cs1302.project2.test.model.loadRecipe;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.LoadRecipes;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeWriteToFile;

class TestGetRecipeWithSameIngredient {

	@Test
	void testEmptyFile() throws IOException {
		LoadRecipes recipes = new LoadRecipes();
		RecipeWriteToFile file = new RecipeWriteToFile();
		file.wipeFile();
		Ingredient item = new Ingredient("Apple", "Fruit");

		assertEquals(0, recipes.getRecipesWithSameIngredient(item).size());
	}

	@Test
	void testNoIngredientsMatch() throws IOException {
		LoadRecipes recipes = new LoadRecipes();
		RecipeWriteToFile file = new RecipeWriteToFile();
		file.wipeFile();
		Ingredient item1 = new Ingredient("Apple", "Fruit");
		Recipe recipe1 = new Recipe("Steak");
		Ingredient item2 = new Ingredient("Beef", "Meat");
		recipe1.addIngredient(item2);
		file.appendFile(recipe1);

		assertEquals(0, recipes.getRecipesWithSameIngredient(item1).size());
	}

	@Test
	void testOneIngredientMatches() throws IOException {
		LoadRecipes recipes = new LoadRecipes();
		RecipeWriteToFile file = new RecipeWriteToFile();
		file.wipeFile();
		Recipe recipe1 = new Recipe("Steak");
		Ingredient item = new Ingredient("Apple", "Fruit");
		recipe1.addIngredient(item);
		file.appendFile(recipe1);

		assertEquals(1, recipes.getRecipesWithSameIngredient(item).size());
		assertEquals(recipe1.getRecipeName(), recipes.getRecipesWithSameIngredient(item).get(0).getRecipeName());
		assertEquals(recipe1.getItems()[0].getName(),
				recipes.getRecipesWithSameIngredient(item).get(0).getItems()[0].getName());
		assertEquals(recipe1.getItems()[0].getType(),
				recipes.getRecipesWithSameIngredient(item).get(0).getItems()[0].getType());
	}

	@Test
	void testTwoIngredientsOneMatches() throws IOException {
		LoadRecipes recipes = new LoadRecipes();
		RecipeWriteToFile file = new RecipeWriteToFile();
		file.wipeFile();
		Recipe recipe1 = new Recipe("Steak");
		Ingredient item = new Ingredient("Apple", "Fruit");
		Ingredient item2 = new Ingredient("Pear", "Fruit");
		Recipe recipe2 = new Recipe("Cake");
		recipe1.addIngredient(item);
		recipe2.addIngredient(item2);
		file.appendFile(recipe1);
		file.appendFile(recipe2);

		assertEquals(1, recipes.getRecipesWithSameIngredient(item).size());
		assertEquals(recipe1.getRecipeName(), recipes.getRecipesWithSameIngredient(item).get(0).getRecipeName());
		assertEquals(recipe1.getItems()[0].getName(),
				recipes.getRecipesWithSameIngredient(item).get(0).getItems()[0].getName());
		assertEquals(recipe1.getItems()[0].getType(),
				recipes.getRecipesWithSameIngredient(item).get(0).getItems()[0].getType());
	}

	@Test
	void testMultipleIngredientMatch() throws IOException {
		LoadRecipes recipes = new LoadRecipes();
		RecipeWriteToFile file = new RecipeWriteToFile();
		file.wipeFile();
		Recipe recipe1 = new Recipe("Steak");
		Ingredient item = new Ingredient("Apple", "Fruit");
		Recipe recipe2 = new Recipe("Cake");
		recipe1.addIngredient(item);
		recipe2.addIngredient(item);
		file.appendFile(recipe1);
		file.appendFile(recipe2);

		assertEquals(2, recipes.getRecipesWithSameIngredient(item).size());
		assertEquals(recipe1.getRecipeName(), recipes.getRecipesWithSameIngredient(item).get(0).getRecipeName());
		assertEquals(recipe1.getItems()[0].getName(),
				recipes.getRecipesWithSameIngredient(item).get(0).getItems()[0].getName());
		assertEquals(recipe1.getItems()[0].getType(),
				recipes.getRecipesWithSameIngredient(item).get(0).getItems()[0].getType());
		assertEquals(recipe2.getRecipeName(), recipes.getRecipesWithSameIngredient(item).get(1).getRecipeName());
		assertEquals(recipe2.getItems()[0].getName(),
				recipes.getRecipesWithSameIngredient(item).get(1).getItems()[0].getName());
		assertEquals(recipe2.getItems()[0].getType(),
				recipes.getRecipesWithSameIngredient(item).get(1).getItems()[0].getType());
	}
}
