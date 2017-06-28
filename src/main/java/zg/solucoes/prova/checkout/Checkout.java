package zg.solucoes.prova.checkout;

/**
 * Created by ygors on 28/06/2017.
 */
public interface Checkout {

    void addProduct(String productId);

    void removeProduct(String productId);

    int getTotalPrice();

    int getTotalDiscount();

}
