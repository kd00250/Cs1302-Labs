package edu.westga.cs1302.project2.test.model.recipeWriteToFile;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeWriteToFile;

class TestAppendFile {

	@Test
	void testSaveNullRecipe() {
		RecipeWriteToFile file = new RecipeWriteToFile();
		assertThrows(IllegalArgumentException.class, () -> {
			file.appendFile(null);
		});
	}

	@Test
	void testDuplicateRecipe() throws IOException {
		RecipeWriteToFile file = new RecipeWriteToFile();
		file.wipeFile();
		Recipe recipe1 = new Recipe("Steak");
		Ingredient item = new Ingredient("Apple", "Fruit");
		recipe1.addIngredient(item);
		file.appendFile(recipe1);
		Recipe recipe2 = new Recipe("Steak");
		recipe2.addIngredient(item);

		assertThrows(IOException.class, () -> {
			file.appendFile(recipe2);
		});
	}

	@Test
	void testNoItems() throws IOException {
		RecipeWriteToFile file = new RecipeWriteToFile();
		file.wipeFile();

		assertThrows(IllegalArgumentException.class, () -> {
			file.appendFile(new Recipe("Steak"));
		});
	}

	@Test
	void testOneItem() throws IOException {
		RecipeWriteToFile file = new RecipeWriteToFile();
		file.wipeFile();
		Recipe recipe = new Recipe("Steak");
		Ingredient item = new Ingredient("Apple", "Fruit");
		recipe.addIngredient(item);
		file.appendFile(recipe);

		File inputFile = new File(RecipeWriteToFile.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("Steak", reader.nextLine());
			assertEquals("Apple,Fruit", reader.nextLine());
			assertFalse(reader.hasNextLine());
		}

	}

	@Test
	void testMultipleItems() throws IOException {
		RecipeWriteToFile file = new RecipeWriteToFile();
		file.wipeFile();
		Recipe recipe = new Recipe("Steak");
		Ingredient item1 = new Ingredient("Apple", "Fruit");
		Ingredient item2 = new Ingredient("Cheese", "Dairy");
		recipe.addIngredient(item1);
		recipe.addIngredient(item2);
		file.appendFile(recipe);

		File inputFile = new File(RecipeWriteToFile.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("Steak", reader.nextLine());
			assertEquals("Apple,Fruit,Cheese,Dairy", reader.nextLine());
			assertFalse(reader.hasNextLine());
		}

	}

	@Test
	void testMultipleRecipes() throws IOException {
		RecipeWriteToFile file = new RecipeWriteToFile();
		file.wipeFile();
		Recipe recipe1 = new Recipe("Steak");
		Recipe recipe2 = new Recipe("Porkchop");
		Ingredient item1 = new Ingredient("Apple", "Fruit");
		Ingredient item2 = new Ingredient("Cheese", "Dairy");
		recipe1.addIngredient(item1);
		recipe1.addIngredient(item2);
		recipe2.addIngredient(item1);
		file.appendFile(recipe1);
		file.appendFile(recipe2);

		File inputFile = new File(RecipeWriteToFile.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("Steak", reader.nextLine());
			assertEquals("Apple,Fruit,Cheese,Dairy", reader.nextLine());
			assertEquals("Porkchop", reader.nextLine());
			assertEquals("Apple,Fruit", reader.nextLine());
			assertFalse(reader.hasNextLine());
		}

	}
}
