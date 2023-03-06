package com.promotion_engine.service;

import com.promotion_engine.model.Cart;

public class PriceCalculationService implements IPriceCalculationService {
    public double calculatePrice(Cart cart){
        // Calculate promoted price.
        double promotedPrice = 0; //TODO implement applyPromo(cart);
        double remainingProductsPrice = 0;

        // TODO Calculate remaining unpromoted products price and assign to remainingProductPrice
        return promotedPrice + remainingProductsPrice;
    }

    private double applyPromo(){
        double totalPromotedPrice = 0;

        //TODO implement the logic

        return totalPromotedPrice;
    }
}
