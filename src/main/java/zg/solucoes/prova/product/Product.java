package zg.solucoes.prova.product;

/**
 * Created by ygors on 28/06/2017.
 */
public class Product {

    private String sku;
    private Integer price;

    public Product(String sku, Integer price) {
        this.sku = sku;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
