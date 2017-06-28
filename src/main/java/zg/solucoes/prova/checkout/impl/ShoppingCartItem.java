package zg.solucoes.prova.checkout.impl;

import zg.solucoes.prova.product.Product;

public class ShoppingCartItem {

	private Product product;
	private int quantity;

	public ShoppingCartItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public ShoppingCartItem(Product product) {
		super();
		this.product = product;
		this.quantity = 1;
	}

	public ShoppingCartItem addQuantity(int quantity) {
		this.quantity += quantity;
		return this;
	}

	public ShoppingCartItem removeQuantity(int quantity) {
		this.quantity -= quantity;
		return this;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public int totalPrice() {
		return product.getPrice() * quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCartItem other = (ShoppingCartItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

}
