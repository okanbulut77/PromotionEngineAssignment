package com.promotion_engine.service;

import com.promotion_engine.model.Cart;
import com.promotion_engine.model.ProductItem;
import com.promotion_engine.model.Promo;

public class SingleProductPromoService implements IPromoService{
    public double calculatePromotedPrice(Cart cart, Promo promo){

        int numberOfPromos = 0;
        //
        ProductItem promotionProductItem = promo.getPromotionProductItemList().get(0);
        int promotionQuantity = promotionProductItem.getAmount();
        ProductItem searchItem = cart.findProductItem(promotionProductItem);

        if(searchItem != null) {
            int cartQuantity = searchItem.getAmount();
            numberOfPromos = cartQuantity / promotionQuantity;
            int remainingItems = cartQuantity % promotionQuantity;
            // reset the remaining items to cart again to calculate their price without offer
            searchItem.setAmount(remainingItems);
        }

        return numberOfPromos * promo.getPromoPrice();
    }
}
