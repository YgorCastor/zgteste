package zg.solucoes.prova.product.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import zg.solucoes.prova.product.Product;
import zg.solucoes.prova.product.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {

	private Map<String, Product> memorydb = new HashMap<>();

	@Override
	public void addItem(String sku, Integer price) {
		memorydb.putIfAbsent(sku, new Product(sku, price));
	}

	@Override
	public Optional<Product> getItem(String sku) {
		return Optional.ofNullable(memorydb.get(sku));
	}

}
