package com.promotion_engine.repository;

import com.promotion_engine.model.Product;
import com.promotion_engine.model.ProductItem;
import com.promotion_engine.model.Promo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PromoRepository implements IPromoRepository {
    public List<Promo> getPromoList(){
        List<Promo> promoList = new ArrayList<Promo>();
        // initialize Promotion List

        promoList.add(new Promo(Arrays.asList(new ProductItem(new Product("A", 50, 0), 3)), 130, false));
        promoList.add(new Promo(Arrays.asList(new ProductItem(new Product("B", 30, 0), 2)), 45, false));
        promoList.add(new Promo(Arrays.asList(
                new ProductItem(new Product("C", 20, 0), 1),
                new ProductItem(new Product("D", 15, 0), 1)), 30, true));

        return promoList;
    }
}
