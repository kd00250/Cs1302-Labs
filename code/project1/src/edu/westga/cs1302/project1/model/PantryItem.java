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
	 * @precondition name != null && type != null
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

	/**
	 * Sets the quantity with the int passed in
	 * 
	 * @precondition quantity > 0
	 * @postcondition none
	 * @param quantity the quantity of the pantry item
	 * 
	 * @return the quantity set by the int passed in
	 */
	public int setQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("Quantity cannot be less than zero");
		}
		
		this.quantity = quantity;
		return this.quantity;
	}

	/**
	 * Takes quantity and adds one to the value
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the quantity one higher than it was previously
	 */
	public int incrementQuantity() {
		return this.quantity++;
	}

	/**
	 * Takes quantity and subtracts one from the value
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the quantity one lower than it was previously
	 */
	public int decrementQuantity() {
		if (quantity == 0) {
			throw new IllegalArgumentException("Quantity is already 0 and cannot go below 0.");
		}

		return this.quantity--;
	}

	@Override
	public String toString() {
		return this.name + "- " + this.quantity;
	}

}
