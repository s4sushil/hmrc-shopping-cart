package com.hmrc.shoppping.model;

/**
 * Enum of products
 * 
 * @author sushil.a.choudhary
 *
 */
public enum ItemEnum {

    APPLE("Apple", 0.60),
    ORANGE("Orange", 0.25);

	private String itemName;
	public String getItemName() {
		return itemName;
	}

	public Double getPrice() {
		return price;
	}

	private Double price;
	
    ItemEnum(String itemName, Double price) {
    	this.itemName = itemName;
    	this.price = price;
    }

}
