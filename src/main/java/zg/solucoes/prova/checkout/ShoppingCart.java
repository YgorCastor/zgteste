package zg.solucoes.prova.checkout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zg.solucoes.prova.checkout.impl.ShoppingCartItem;
import zg.solucoes.prova.product.Product;

public class ShoppingCart {

	private Map<String, ShoppingCartItem> itens = new HashMap<>();

	public void addProduct(Product product, int quantity) {
		itens.computeIfPresent(product.getSku(), (sku, cartItem) -> cartItem.addQuantity(quantity));
		itens.putIfAbsent(product.getSku(), new ShoppingCartItem(product,quantity));
	}

	public void removeProduct(Product product, int quantity) {
		itens.computeIfPresent(product.getSku(), (sku, cartItem) -> cartItem.removeQuantity(quantity));
	}

	public List<ShoppingCartItem> itens() {
		return Collections.unmodifiableList(new ArrayList<>(itens.values()));
	}

}
