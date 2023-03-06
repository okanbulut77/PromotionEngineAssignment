package com.promotion_engine.service;

import com.promotion_engine.model.Cart;
import com.promotion_engine.model.ProductItem;
import com.promotion_engine.model.Promo;

public class BundledPromoService implements IPromoService{
    public double calculatePromotedPrice(Cart cart, Promo promo){
        int numberOfPromos = 0;
        // Multiple products promotion type
        for(ProductItem productItem : promo.getPromotionProductItemList()) {
            // get the required amount of each product to meet promotion requirements
            int requiredAmount = productItem.getAmount();
            ProductItem searchItem = cart.findProductItem(productItem);

            if(searchItem == null) {
                return 0;
            }
            int cartAmount = searchItem.getAmount();
            //Depending on the products amount in the Cart there can be 1 or more bundle combinations.
            // E.g. 3 C and 2 D means (C+D)X2 promo and 1 remaining C
            if(cartAmount / requiredAmount < numberOfPromos || numberOfPromos == 0) {
                numberOfPromos = cartAmount / requiredAmount;
            }
        }
        // remove the items which are part of multi product promotion combination (Apply only one promotion at a time!!!)
        for (ProductItem productItem : promo.getPromotionProductItemList()) {
            ProductItem cartProductItemItem = cart.findProductItem(productItem);
            if(cartProductItemItem != null) {
                cartProductItemItem.setAmount(cartProductItemItem.getAmount() - numberOfPromos * productItem.getAmount());
            }
        }
        return numberOfPromos * promo.getPromoPrice();
    }
}
