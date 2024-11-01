package edu.westga.cs1302.project2.test.model.loadRecipe;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.LoadRecipes;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeWriteToFile;

class TestLoadFile {

	@Test
	void testEmptyFile() throws IOException {
		RecipeWriteToFile file = new RecipeWriteToFile();
		file.wipeFile();
		LoadRecipes recipes = new LoadRecipes();
		recipes.loadFile();
		assertTrue(recipes.loadFile().size() == 0);
	}
	
	@Test
	void testOneRecipeFile() throws IOException {
		LoadRecipes recipes = new LoadRecipes();
		RecipeWriteToFile file = new RecipeWriteToFile();
		file.wipeFile();
		Recipe recipe1 = new Recipe("Steak");
		Ingredient item = new Ingredient("Apple", "Fruit");
		recipe1.addIngredient(item);
		file.appendFile(recipe1);
		
		
		assertEquals(1, recipes.loadFile().size());
		assertEquals(recipe1.getRecipeName(), recipes.loadFile().get(0).getRecipeName());
		assertEquals(recipe1.getItems()[0].getName(), recipes.loadFile().get(0).getItems()[0].getName());
		assertEquals(recipe1.getItems()[0].getType(), recipes.loadFile().get(0).getItems()[0].getType());
	}
	
	@Test
	void testMultipleRecipeInFile() throws IOException {
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
		recipes.loadFile();
		
		assertEquals(2, recipes.loadFile().size());
		assertEquals(recipe1.getRecipeName(), recipes.loadFile().get(0).getRecipeName());
		assertEquals(recipe1.getItems()[0].getName(), recipes.loadFile().get(0).getItems()[0].getName());
		assertEquals(recipe1.getItems()[0].getType(), recipes.loadFile().get(0).getItems()[0].getType());
		assertEquals(recipe2.getRecipeName(), recipes.loadFile().get(1).getRecipeName());
		assertEquals(recipe2.getItems()[0].getName(), recipes.loadFile().get(1).getItems()[0].getName());
		assertEquals(recipe2.getItems()[0].getType(), recipes.loadFile().get(1).getItems()[0].getType());
		
	}

}
