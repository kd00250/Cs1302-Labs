package edu.westga.cs1302.project1.tests.model.pantryItem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.PantryItem;

class TestDecrementQuantity {

	@Test
	void testSubtractFromDefaultQuantity() {
		PantryItem item = new PantryItem("Apple", "Fruit");

		assertThrows(IllegalArgumentException.class, () -> {
			item.decrementQuantity();
		});
	}

	@Test
	void testSubtractFromSetQuantity() {
		PantryItem item = new PantryItem("Apple", "Fruit");
		item.setQuantity(21);
		item.decrementQuantity();

		assertEquals(20, item.getQuantity());
	}

}
