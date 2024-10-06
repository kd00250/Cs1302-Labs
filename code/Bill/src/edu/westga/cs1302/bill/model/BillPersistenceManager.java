package edu.westga.cs1302.bill.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Supports saving and loading bill data,
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class BillPersistenceManager {

	public static final String DATA_FILE = "data.txt";

	/**
	 * Save the bill!
	 * 
	 * Writes all bill data to DATA_FILE
	 * 
	 * @precondition bill != null
	 * @postcondition none
	 * 
	 * @throws IllegalArgumentException when precondition is violated
	 * @throws IOException              invalid or missing name/amount found when
	 *                                  trying to write to a file
	 * @param bill the bill to save
	 */
	public static void saveBillData(Bill bill) throws IllegalArgumentException, IOException {
		if (bill == null) {
			throw new IllegalArgumentException("Bill cannot be null");
		}
		try (FileWriter writer = new FileWriter(DATA_FILE)) {
			for (BillItem currentItem : bill.getItems()) {
				writer.write(currentItem.getName() + "," + currentItem.getAmount() + System.lineSeparator());
			}
		}
	}

	/**
	 * Load the bill!
	 * 
	 * Reads from DATA_FILE File is assumed to use the same format as saveBillData
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the bill loaded
	 * @throws IOException           File is invalid or missing name/amount
	 *                               when trying to create a new billItem
	 * @throws FileNotFoundException file at the DATA_FILE does not exist
	 */
	public static Bill loadBillData() throws IOException, FileNotFoundException {
		File inputFile = new File(DATA_FILE);
		Bill bill = new Bill();
		try (Scanner reader = new Scanner(inputFile)) {
			for (int lineNumber = 1; reader.hasNextLine(); lineNumber++) {
				String baseLine = reader.nextLine();
				String strippedLine = baseLine.strip();
				String[] parts = strippedLine.split(",");
				try {
					String name = parts[0];
					double amount = Double.parseDouble(parts[1]);
					BillItem nextItem = new BillItem(name, amount);
					bill.addItem(nextItem);
				} catch (NumberFormatException numError) {
					throw new IOException(
							"Cannot read amount (was not a valid double) on line " + lineNumber + " : " + strippedLine);
				} catch (IllegalArgumentException argError) {
					throw new IOException(
							"Cannont create bill item (name is invalid) on line " + lineNumber + " : " + strippedLine);
				} catch (IndexOutOfBoundsException indexError) {
					throw new IOException("Missing either name or amount on line " + lineNumber + " : " + strippedLine);
				}
			}
		}
		return bill;
	}

}
