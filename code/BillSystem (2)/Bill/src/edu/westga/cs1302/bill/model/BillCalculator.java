package edu.westga.cs1302.bill.model;

public class BillCalculator {
	public static final double TAX_PERCENT = 0.1;
	public static final double TIP_PERCENT = 0.2;
	
	/**
	 * Return the subtotal for the bill
	 * 
	 * @return the subtotal for the bill
	 */
	public static double getSubTotal(BillItem[] items) {
		double subTotal = 0.0;
		for (int index = 0; index < items.length; index++) {
			BillItem item = items[index];
			if (item != null) {
				subTotal += item.getAmount();
			}
		}
		return subTotal;
	}
	
	/**
	 * Return the tax for the bill
	 * 
	 * @return the tax for the bill
	 */
	public static double getTax(BillItem[] items) {
		return getSubTotal(items) * TAX_PERCENT;		
	}
	
	/**
	 * Return the tip for the bill
	 * 
	 * @return the tip for the bill
	 */
	public static double getTip(BillItem[] items) {
		return getSubTotal(items) * TIP_PERCENT;
	}
	
	/**
	 * Return the total for the bill
	 * 
	 * @return the total for the bill
	 */
	public static double getTotal(BillItem[] items) {
		return getSubTotal(items) + getTax(items) + getTip(items);
	}

}
