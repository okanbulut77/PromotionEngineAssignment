package com.promotion_engine.service;

import com.promotion_engine.model.Cart;
import com.promotion_engine.model.Promo;

public interface IPromoService {
    public double calculatePromotedPrice(Cart cart, Promo promo);
}
