package hu.modsstore.webshop;

import java.io.Serializable;

public class CartItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long itemID;

	private String itemName;

	private long count;

	private long totalPrice;

	private long itemPrice;

	private String size;

	private String itemCode;

	public CartItem(long itemID, String itemName, long itemPrice, long count,
			String size, String itemCode) {
		super();
		this.count = count;
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.totalPrice = itemPrice;
		this.size = size;
		this.itemCode = itemCode;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(long itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

}
