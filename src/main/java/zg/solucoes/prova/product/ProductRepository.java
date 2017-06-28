 package zg.solucoes.prova.product;

import java.util.Optional;

/**
 * Created by ygors on 28/06/2017.
 */
public interface ProductRepository {

    void addItem(String sku, Integer price);

    Optional<Product> getItem(String sku);

}
