package com.promotion_engine.service;

import com.promotion_engine.model.Cart;

public interface IPriceCalculationService {

    public double calculatePrice(Cart cart);

}
