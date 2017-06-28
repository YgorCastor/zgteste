package zg.solucoes.prova.checkout.discount.impl;

import zg.solucoes.prova.checkout.discount.DiscountPolicy;
import zg.solucoes.prova.checkout.impl.ShoppingCartItem;

public class QtdFree implements DiscountPolicy {

	private ShoppingCartItem item;
	int qtd;
	int qtdFree;

	public QtdFree(ShoppingCartItem item, int qtd, int qtdFree) {
		this.item = item;
		this.qtd = qtd;
		this.qtdFree = qtdFree;
	}

	@Override
	public int apply() {
		int qtdInPromotion = item.getQuantity() / qtd;
		int totalValue = (item.getQuantity() - qtdInPromotion) * item.getProduct().getPrice();
		return totalValue;
	}

}
