package zg.solucoes.prova.checkout.discount.impl;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import zg.solucoes.prova.checkout.discount.DiscountPolicy;
import zg.solucoes.prova.checkout.impl.ShoppingCartItem;
import zg.solucoes.prova.product.Product;

public class QuantityByValueTest {
	private ShoppingCartItem shoppingCartItem;

	@Before
	public void setUp() {
		Product product = new Product("A", 50);
		shoppingCartItem = new ShoppingCartItem(product);
	}

	@Test
	public void testApply_OneInPromotion() throws Exception {
		shoppingCartItem.addQuantity(2);
		DiscountPolicy discount = new QuantityByValue(shoppingCartItem, 3, 130);
		assertThat(discount.apply()).isEqualTo(130);
	}
	
	@Test
	public void testApply_NotInPromotion() throws Exception {
		shoppingCartItem.addQuantity(1);
		DiscountPolicy discount = new QuantityByValue(shoppingCartItem, 3, 130);
		assertThat(discount.apply()).isEqualTo(100);
	}
	
	@Test
	public void testApply_OneInPromotionOneNot() throws Exception {
		shoppingCartItem.addQuantity(3);
		DiscountPolicy discount = new QuantityByValue(shoppingCartItem, 3, 130);
		assertThat(discount.apply()).isEqualTo(180);
	}
	
	@Test
	public void testApply_TwoInPromotion() throws Exception {
		shoppingCartItem.addQuantity(5);
		DiscountPolicy discount = new QuantityByValue(shoppingCartItem, 3, 130);
		assertThat(discount.apply()).isEqualTo(260);
	}


}
