package zg.solucoes.prova.checkout.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import zg.solucoes.prova.checkout.Checkout;
import zg.solucoes.prova.checkout.discount.impl.PriceCalculator;
import zg.solucoes.prova.product.ProductRepository;
import zg.solucoes.prova.product.impl.ProductRepositoryImpl;

public class CheckoutImplTest {

    private Checkout checkout;

    @Before
    public void setUp() {
        ProductRepository items = new ProductRepositoryImpl();
        PriceCalculator calculator = new PriceCalculator();
        items.addItem("A", 50);
        items.addItem("B", 30);
        items.addItem("C", 20);
        items.addItem("D", 15);

        checkout = new CheckoutImpl(items,calculator);
    }

    @Test
    public void checkoutTest_1() {
        checkout.addProduct("A");

        assertThat(checkout.getTotalPrice()).isEqualTo(50);
        assertThat(checkout.getTotalDiscount()).isEqualTo(0);

        checkout.addProduct("A");

        assertThat(checkout.getTotalPrice()).isEqualTo(100);
        assertThat(checkout.getTotalDiscount()).isEqualTo(0);

        checkout.addProduct("A");

        assertThat(checkout.getTotalPrice()).isEqualTo(130);
        assertThat(checkout.getTotalDiscount()).isEqualTo(20);

        checkout.addProduct("A");

        assertThat(checkout.getTotalPrice()).isEqualTo(180);
        assertThat(checkout.getTotalDiscount()).isEqualTo(20);

        checkout.addProduct("A");

        assertThat(checkout.getTotalPrice()).isEqualTo(230);
        assertThat(checkout.getTotalDiscount()).isEqualTo(20);

        checkout.addProduct("A");

        assertThat(checkout.getTotalPrice()).isEqualTo(260);
        assertThat(checkout.getTotalDiscount()).isEqualTo(40);

        checkout.removeProduct("A");

        assertThat(checkout.getTotalPrice()).isEqualTo(230);
        assertThat(checkout.getTotalDiscount()).isEqualTo(20);
    }

    @Test
    public void checkoutTest_2() {
        checkout.addProduct("D");
        assertThat(checkout.getTotalPrice()).isEqualTo(15);
        assertThat(checkout.getTotalDiscount()).isEqualTo(0);
        checkout.addProduct("A");
        assertThat(checkout.getTotalPrice()).isEqualTo(65);
        assertThat(checkout.getTotalDiscount()).isEqualTo(0);
        checkout.addProduct("B");
        assertThat(checkout.getTotalPrice()).isEqualTo(95);
        assertThat(checkout.getTotalDiscount()).isEqualTo(0);
        checkout.addProduct("A");
        assertThat(checkout.getTotalPrice()).isEqualTo(145);
        assertThat(checkout.getTotalDiscount()).isEqualTo(0);
        checkout.addProduct("B");
        assertThat(checkout.getTotalPrice()).isEqualTo(160);
        assertThat(checkout.getTotalDiscount()).isEqualTo(15);
        checkout.addProduct("A");
        assertThat(checkout.getTotalPrice()).isEqualTo(190);
        assertThat(checkout.getTotalDiscount()).isEqualTo(35);
        checkout.removeProduct("A");
        assertThat(checkout.getTotalPrice()).isEqualTo(160);
        assertThat(checkout.getTotalDiscount()).isEqualTo(15);
        checkout.removeProduct("B");
        assertThat(checkout.getTotalPrice()).isEqualTo(145);
        assertThat(checkout.getTotalDiscount()).isEqualTo(0);
    }

    @Test
    public void checkoutTest_3() {
        checkout.addProduct("C");
        assertThat(checkout.getTotalPrice()).isEqualTo(20);
        assertThat(checkout.getTotalDiscount()).isEqualTo(0);
        checkout.addProduct("C");
        assertThat(checkout.getTotalPrice()).isEqualTo(40);
        assertThat(checkout.getTotalDiscount()).isEqualTo(0);
        checkout.addProduct("C");
        assertThat(checkout.getTotalPrice()).isEqualTo(40);
        assertThat(checkout.getTotalDiscount()).isEqualTo(20);
        checkout.addProduct("C");
        assertThat(checkout.getTotalPrice()).isEqualTo(60);
        assertThat(checkout.getTotalDiscount()).isEqualTo(20);
        checkout.removeProduct("C");
        assertThat(checkout.getTotalPrice()).isEqualTo(40);
        assertThat(checkout.getTotalDiscount()).isEqualTo(20);
        checkout.removeProduct("C");
        assertThat(checkout.getTotalPrice()).isEqualTo(40);
        assertThat(checkout.getTotalDiscount()).isEqualTo(0);
    }

    @Test
    public void checkoutTest_4() {
        checkout.addProduct("C");
        assertThat(checkout.getTotalPrice()).isEqualTo(20);
        assertThat(checkout.getTotalDiscount()).isEqualTo(0);
        checkout.addProduct("B");
        assertThat(checkout.getTotalPrice()).isEqualTo(50);
        assertThat(checkout.getTotalDiscount()).isEqualTo(0);
        checkout.addProduct("B");
        assertThat(checkout.getTotalPrice()).isEqualTo(65);
        assertThat(checkout.getTotalDiscount()).isEqualTo(15);
        checkout.removeProduct("B");
        assertThat(checkout.getTotalPrice()).isEqualTo(50);
        assertThat(checkout.getTotalDiscount()).isEqualTo(0);
    }

}
