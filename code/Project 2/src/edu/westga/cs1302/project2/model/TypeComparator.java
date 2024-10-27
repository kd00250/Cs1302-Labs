package edu.westga.cs1302.project2.model;

import java.util.Comparator;

/**
 * The TypeComparator class
 * 
 * @author CS 1302
 * @version fall 2024
 */
public class TypeComparator implements Comparator<Ingredient> {

	@Override
	public int compare(Ingredient ingredient1, Ingredient ingredient2) {
		if (ingredient1.getType().equals(ingredient2.getType())) {
			return 0;
		}
		return ingredient1.getType().compareTo(ingredient2.getType());
	}

	@Override
	public String toString() {
		return "Type";
	}
}
