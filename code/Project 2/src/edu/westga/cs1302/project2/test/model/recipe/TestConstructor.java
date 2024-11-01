package edu.westga.cs1302.project2.test.model.recipe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Recipe;

class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Recipe(null);
		});
	}

	@Test
	void testEmptyName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Recipe("");
		});
	}

	@Test
	void testBlankName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Recipe(" ");
		});
	}

	@Test
	void testValidConstructor() {
		Recipe recipe = new Recipe("Steak");

		assertEquals(0, recipe.getItems().length);
	}

}
