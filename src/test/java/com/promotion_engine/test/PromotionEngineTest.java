package com.promotion_engine.test;

import com.promotion_engine.model.Cart;
import com.promotion_engine.model.Product;
import com.promotion_engine.model.ProductItem;
import com.promotion_engine.repository.IPromoRepository;
import com.promotion_engine.repository.PromoRepository;
import com.promotion_engine.service.IPriceCalculationService;
import com.promotion_engine.service.PriceCalculationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PromotionEngineTest {
    IPriceCalculationService priceService;
    IPromoRepository promoRepository;

    @BeforeEach
    void beforeEach() {
        this.promoRepository = new PromoRepository();
        this.priceService = new PriceCalculationService(this.promoRepository);
    }

    @Test
    //No matching promo
    void testScenarioA() {

        Cart cart = new Cart(Arrays.asList(new ProductItem(new Product("A", 50, 0), 1),
                new ProductItem(new Product("B", 30, 0), 1),
                new ProductItem(new Product("C", 20, 0), 1)
        ));
        double expectedValue = 100;
        double actualValue = this.priceService.calculatePrice(cart);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testScenarioB() {
        Cart cart = new Cart(Arrays.asList(new ProductItem(new Product("A", 50, 0), 5),
                new ProductItem(new Product("B", 30, 0), 5),
                new ProductItem(new Product("C", 20, 0), 1)
        ));

        double expectedValue = 370;
        double actualValue = this.priceService.calculatePrice(cart);
        assertEquals(expectedValue, actualValue);
    }
    @Test
    void testScenarioC() {
        Cart cart = new Cart(Arrays.asList(new ProductItem(new Product("A", 50, 0), 3),
                new ProductItem(new Product("B", 30, 0), 5),
                new ProductItem(new Product("C", 20, 0), 1),
                new ProductItem(new Product("D", 15, 0), 1)
        ));

        double expectedValue = 280;
        double actualValue = this.priceService.calculatePrice(cart);
        assertEquals(expectedValue, actualValue);
    }


}
