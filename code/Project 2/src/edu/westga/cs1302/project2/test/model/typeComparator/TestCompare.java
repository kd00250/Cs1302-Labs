package edu.westga.cs1302.project2.test.model.typeComparator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.NameComparator;

class TestCompare {

	@Test
	void testCompareFirstIngredientIsGreater() {
		Ingredient ingredient1 = new Ingredient("Apple", "Fruit");
		Ingredient ingredient2 = new Ingredient("Flour", "Other");
		Comparator<Ingredient> comparator = new NameComparator();

		assertEquals(-5, comparator.compare(ingredient1, ingredient2));
	}

	@Test
	void testCompareSecondIngredientIsGreater() {
		Ingredient ingredient1 = new Ingredient("Flour", "Other");
		Ingredient ingredient2 = new Ingredient("Apple", "Fruit");
		Comparator<Ingredient> comparator = new NameComparator();

		assertEquals(5, comparator.compare(ingredient1, ingredient2));
	}

	@Test
	void testCompareBothIngredientIsEqual() {
		Ingredient ingredient1 = new Ingredient("Flour", "Other");
		Ingredient ingredient2 = new Ingredient("Flour", "Other");
		Comparator<Ingredient> comparator = new NameComparator();

		assertEquals(0, comparator.compare(ingredient1, ingredient2));
	}

}
