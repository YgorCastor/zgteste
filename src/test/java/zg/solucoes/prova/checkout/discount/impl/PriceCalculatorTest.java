package zg.solucoes.prova.checkout.discount.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import zg.solucoes.prova.checkout.ShoppingCart;
import zg.solucoes.prova.product.Product;

public class PriceCalculatorTest {

	private PriceCalculator discountPolicy = new PriceCalculator();
	private ShoppingCart shoppingCart;

	@Before
	public void setUp() {
		this.shoppingCart = new ShoppingCart();
	}

	@Test
	public void testTotal() throws Exception {
		Product productA = new Product("A", 50);
		Product productC = new Product("C", 20);

		shoppingCart.addProduct(productA, 3);
		shoppingCart.addProduct(productC, 3);

		int totalValue = discountPolicy.total(shoppingCart);
		assertThat(totalValue).isEqualTo(170);
	}

	@Test
	public void testTotalWithoutDiscounts() throws Exception {
		Product productA = new Product("A", 50);
		Product productC = new Product("C", 20);
		
		shoppingCart.addProduct(productA, 3);
		shoppingCart.addProduct(productC, 3);
		
		int totalValue = discountPolicy.totalWithoutDiscounts(shoppingCart);
		assertThat(totalValue).isEqualTo(210);
	}

}
