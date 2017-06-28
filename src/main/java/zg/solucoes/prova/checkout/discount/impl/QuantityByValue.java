package zg.solucoes.prova.checkout.discount.impl;

import zg.solucoes.prova.checkout.discount.DiscountPolicy;
import zg.solucoes.prova.checkout.impl.ShoppingCartItem;

public class QuantityByValue implements DiscountPolicy {

	private ShoppingCartItem item;
	private int qtd;
	private int promotionalPrice;
	
	public static QuantityByValue create(ShoppingCartItem item, int qtd, int promotionalPrice) {
		QuantityByValue quantityByValue = new QuantityByValue(item, qtd, promotionalPrice);
		return quantityByValue;
	}

	QuantityByValue(ShoppingCartItem item, int qtd, int promotionalPrice) {
		this.item = item;
		this.qtd = qtd;
		this.promotionalPrice = promotionalPrice;
	}

	@Override
	public int apply() {
		int itensInDiscount = (item.getQuantity() / qtd);
		int discountTotal = itensInDiscount * promotionalPrice;
		int itensInNormalValue = item.getQuantity() - ( itensInDiscount * qtd) ;
		int normalValue = itensInNormalValue * item.getProduct().getPrice();
		return normalValue + discountTotal;
	}

}
