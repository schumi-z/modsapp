package hu.modsstore.webshop;

import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<CartItem> cart = new ArrayList<CartItem>();

	private long totalPrice;

	public ShoppingCart() {

	}

	// add
	public void addItem(CartItem item) {
		getCart().add(item);
	}

	// remove selected
	public void removeItemById(long id) {
		ArrayList<CartItem> actCart = getCart();

		for (CartItem item : getCart()) {
			if (item.getItemID() == id) {
				actCart.remove(item);
			}

		}
	}

	// remove all item
	public void removeAllItem() {
		ArrayList<CartItem> actCart = getCart();

		for (CartItem item : getCart()) {

			actCart.remove(item);

		}
	}

	public ArrayList<CartItem> getCart() {
		return cart;
	}

	public void setCart(ArrayList<CartItem> cart) {
		this.cart = cart;
	}

	public long getTotalPrice() {

		long summarum = 0;

		for (CartItem item : getCart()) {
			summarum += item.getTotalPrice();
		}

		return summarum;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

}
