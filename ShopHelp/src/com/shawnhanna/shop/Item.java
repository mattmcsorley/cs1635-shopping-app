package com.shawnhanna.shop;



/*
 * CLASS DESCRIPTION
 * This class is used to store item information and status after a query is performed.
 * quantity MUST be tracked and pushed back to the server. The other class
 * variables only have accessors, and not manipulators because their values must match
 * the server values
 */
public class Item {
	private String name;
	private String shortName;
	private double price;
	private String barcode; // NOTE: I dont actually know how barcodes are
							// stored - john, 3/25
	private int quantity;
	private int locationID;
	private boolean checked;

	// all items are initialized from the parameters, but quantity is set to 0,
	// and inCart is set to false
	public Item(String newName, String newShortName, double newPrice,
			String newBarcode, int newLocationID , boolean isChecked) {
		name = newName;
		shortName = newShortName;
		price = newPrice;
		barcode = newBarcode;
		locationID = newLocationID;
		quantity = 1;
		checked = isChecked;
	}

	public Item() {
		name = "NO NAME";
		shortName = "NO NAME";
		price = -1;
		barcode = "";
		locationID = -1;
		quantity = -1;
		checked = false;
	}

	public String getName() {
		return name;
	}

	public String getShortName() {
		return shortName;
	}

	public double getLocationID() {
		return locationID;
	}

	public String getBarcode() {
		return barcode;
	}

	public double getPrice() {
		return price;
	}

	public int incrementQuantity() {
		return quantity++;
	}

	public int decrementQuantity() {
		if(quantity > 0)return quantity--;
		else return 0;
	}

	public int setQuantityToZero() {
		return quantity = 0;
	}

	public int getQuantity() {
		return quantity;
	}

	public int setQuantity(int newQuantity) {
		return quantity = newQuantity;
	}
	
	public boolean getChecked(){
		return checked;
	}
	public boolean invertCheck(){
		if(checked) checked=false;
		else checked=true;
		return checked;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Item))
			return false;
		Item otherItem = (Item) other;
		if (otherItem.getPrice() != getPrice())
			return false;
		if (otherItem.getBarcode() != getBarcode())
			return false;
		if (otherItem.getLocationID() != getLocationID())
			return false;
		if (otherItem.getName() != getName())
			return false;
		return true;
	}
}
