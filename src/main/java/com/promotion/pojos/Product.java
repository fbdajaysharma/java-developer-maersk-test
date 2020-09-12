/**
 * 
 */
package com.promotion.pojos;

/**
 * @author Ajay Kumar
 *
 */
public class Product {
	private int price;
	private char skuId;

	public Product(char skuId, int price){
		this.price = price;
		this.skuId = skuId;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public char getSkuId() {
		return skuId;
	}
	public void setSkuId(char skuId) {
		this.skuId = skuId;
	}
	
	
}
