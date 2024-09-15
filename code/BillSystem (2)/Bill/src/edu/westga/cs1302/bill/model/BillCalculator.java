package edu.westga.cs1302.bill.model;

public class BillCalculator {
	public static final double TAX_PERCENT = 0.1;
	public static final double TIP_PERCENT = 0.2;
	
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
	
	public static double getTax(BillItem[] items) {
		return getSubTotal(items) * TAX_PERCENT;		
	}
	
	public static double getTip(BillItem[] items) {
		return getSubTotal(items) * TIP_PERCENT;
	}
	
	public static double getTotal(BillItem[] items) {
		return getSubTotal(items) + getTax(items) + getTip(items);
	}

}
