package edu.westga.cs1302.project1.tests.model.pantryItem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.PantryItem;

class TestSetQuantity {

	@Test
	void testLessThanZero() {
		PantryItem item = new PantryItem("Apple", "Fruit");
		assertThrows(IllegalArgumentException.class, () -> {
			item.setQuantity(-1);
		});
	}
	
	@Test
	void testSetValidQuantity() {
		PantryItem item = new PantryItem("Apple", "Fruit");
		item.setQuantity(12);

		assertEquals(12, item.getQuantity());
	}

}
