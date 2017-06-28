package zg.solucoes.prova.checkout.impl;

import java.util.Optional;

import zg.solucoes.prova.checkout.Checkout;
import zg.solucoes.prova.checkout.ShoppingCart;
import zg.solucoes.prova.checkout.discount.impl.PriceCalculator;
import zg.solucoes.prova.product.Product;
import zg.solucoes.prova.product.ProductRepository;

/**
 * Created by ygors on 28/06/2017.
 */
class CheckoutImpl implements Checkout {

	private final ProductRepository productRepository;
	private ShoppingCart shoppingCart = new ShoppingCart();
	private final PriceCalculator calculator;

	CheckoutImpl(ProductRepository productRepository, PriceCalculator calculator) {
		this.productRepository = productRepository;
		this.calculator = calculator;
	}

	@Override
	public void addProduct(String productId) {
		Optional<Product> product = productRepository.getItem(productId);
		product.ifPresent(prod -> shoppingCart.addProduct(prod, 1));
	}

	@Override
	public void removeProduct(String productId) {
		Optional<Product> product = productRepository.getItem(productId);
		product.ifPresent(prod -> shoppingCart.removeProduct(prod, 1));
	}

	@Override
	public int getTotalPrice() {
		return calculator.total(shoppingCart);
	}

	@Override
	public int getTotalDiscount() {
		return calculator.getTotalDiscount(shoppingCart);
	}
}
