package edu.westga.cs1302.project2.test.model.nameComparator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.NameComparator;

class TestToString {

	@Test
	void testToString() {
		Comparator<Ingredient> comparator = new NameComparator();
		
		assertEquals("Name", comparator.toString());
	}

}
