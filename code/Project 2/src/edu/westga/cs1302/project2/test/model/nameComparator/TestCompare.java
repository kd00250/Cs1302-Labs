package edu.westga.cs1302.project2.test.model.nameComparator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.NameComparator;

class TestCompare {

	@Test
	void testCompareFirstIngredientIsGreater() {
		Ingredient ingredient1 = new Ingredient("Carrot", "Veggie");
		Ingredient ingredient2 = new Ingredient("Flour", "Other");
		Comparator<Ingredient> comparator = new NameComparator();

		assertEquals(-3, comparator.compare(ingredient1, ingredient2));
	}

	@Test
	void testCompareSecondIngredientIsGreater() {
		Ingredient ingredient1 = new Ingredient("Flour", "Other");
		Ingredient ingredient2 = new Ingredient("Carrot", "Veggie");
		Comparator<Ingredient> comparator = new NameComparator();

		assertEquals(3, comparator.compare(ingredient1, ingredient2));
	}

	@Test
	void testCompareBothIngredientIsEqual() {
		Ingredient ingredient1 = new Ingredient("Flour", "Other");
		Ingredient ingredient2 = new Ingredient("Flour", "Other");
		Comparator<Ingredient> comparator = new NameComparator();

		assertEquals(0, comparator.compare(ingredient1, ingredient2));
	}

}
