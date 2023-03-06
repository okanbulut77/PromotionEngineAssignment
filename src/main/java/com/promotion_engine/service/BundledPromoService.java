package com.promotion_engine.service;

import com.promotion_engine.model.Cart;
import com.promotion_engine.model.Promo;

public class BundledPromoService implements IPromoService{
    public double calculatePromotedPrice(Cart cart, Promo promo){
        return 0.00;
    }
}
