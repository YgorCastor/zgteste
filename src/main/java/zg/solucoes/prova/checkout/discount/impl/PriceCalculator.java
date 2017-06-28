package zg.solucoes.prova.checkout.discount.impl;

import java.util.Collection;
import java.util.function.Function;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import zg.solucoes.prova.checkout.ShoppingCart;
import zg.solucoes.prova.checkout.impl.ShoppingCartItem;

public class PriceCalculator {

	private Multimap<String, Function<ShoppingCartItem, Integer>> policies = ArrayListMultimap.create();

	public PriceCalculator() {
		policies.put("A", (item) -> new QuantityByValue(item, 3, 130).apply());
		policies.put("B", (item) -> new QuantityByValue(item, 2, 45).apply());
		policies.put("C", (item) -> new QtdFree(item, 3, 2).apply());
	}

	public int totalWithoutDiscounts(ShoppingCart shoppingCart) {
		return shoppingCart.itens().parallelStream().mapToInt(i -> i.totalPrice()).sum();
	}
	
	public int getTotalDiscount(ShoppingCart cart) {
		return totalWithoutDiscounts(cart) - total(cart);		
	}

	public int total(ShoppingCart shoppingCart) {
		int totalDiscount = 0;
		for (ShoppingCartItem item : shoppingCart.itens()) {
			totalDiscount = discountsForProduct(totalDiscount, item);
		}
		return totalDiscount;
	}
	
	private int discountsForProduct(int totalDiscount, ShoppingCartItem item) {
		Collection<Function<ShoppingCartItem, Integer>> discounts = policies.get(item.getProduct().getSku());
		
		if(discounts.isEmpty()) {
			return totalDiscount += item.totalPrice();
		}
		
		for (Function<ShoppingCartItem, Integer> policy : discounts) {
			totalDiscount += policy.apply(item);
		}
		return totalDiscount;
	}

}
