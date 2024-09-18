package edu.westga.cs1302.project1.model;

/**
 * Manages a set of PantryItems.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class PantryItem {
	
	private final String name;
	private final String type;
	private int quantity;
	
	/**
	 * creates a new pantry item with the name
	 * 
	 * @precondition name != null && type != null && quantity > 0
	 * @postcondition getName() == name && getType() == type
	 * 
	 * @param name the name of the item
	 * @param type the type of item
	 */
	public PantryItem(String name, String type) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}
		if (type == null) {
			throw new IllegalArgumentException("Type cannot be null.");
		}
		
		this.name = name;
		this.type = type;
		this.quantity = 0;
		
	}
	
	/**
	 * Return the name for the pantry item
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name for the pantry item
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Return the type for the pantry item
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the type for the pantry item
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Return the quantity for the pantry item
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the quantity for the pantry item
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	@Override
	public String toString() {
		return this.name + "- " + this.quantity;
	}

}
