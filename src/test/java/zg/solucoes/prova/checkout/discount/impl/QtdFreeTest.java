package zg.solucoes.prova.checkout.discount.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import zg.solucoes.prova.checkout.discount.DiscountPolicy;
import zg.solucoes.prova.checkout.impl.ShoppingCartItem;
import zg.solucoes.prova.product.Product;

public class QtdFreeTest {

	private ShoppingCartItem shoppingCartItem;

	@Before
	public void setUp() {
		Product product = new Product("C", 20);
		shoppingCartItem = new ShoppingCartItem(product);
	}

	@Test
	public void testApply_OneFree() throws Exception {
		shoppingCartItem.addQuantity(2);
		DiscountPolicy discount = new QtdFree(shoppingCartItem, 3, 1);
		assertThat(discount.apply()).isEqualTo(40);
	}

	@Test
	public void testApply_OneFreeThreeNot() throws Exception {
		shoppingCartItem.addQuantity(3);
		DiscountPolicy discount = new QtdFree(shoppingCartItem, 3, 1);
		assertThat(discount.apply()).isEqualTo(60);
	}

	@Test
	public void testApply_TwoFreeFourNot() throws Exception {
		shoppingCartItem.addQuantity(5);
		DiscountPolicy discount = new QtdFree(shoppingCartItem, 3, 1);
		assertThat(discount.apply()).isEqualTo(80);
	}

}
