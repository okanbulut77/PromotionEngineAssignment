package com.promotion_engine.service;

import com.promotion_engine.model.Cart;
import com.promotion_engine.model.ProductItem;
import com.promotion_engine.model.Promo;
import com.promotion_engine.repository.IPromoRepository;

import java.util.List;

public class PriceCalculationService implements IPriceCalculationService {
    IPromoRepository promoRepository;

    public PriceCalculationService(IPromoRepository promoRepository) {
        this.promoRepository = promoRepository;
    }

    public double calculatePrice(Cart cart){
        // Calculate promoted price.
        double promotedPrice = applyPromo(cart);
        double remainingProductsPrice = 0;

        // Calculate remaining unpromoted products price and assign to remainingProductPrice
        for (ProductItem productItem: cart.getProductItems()) {
            remainingProductsPrice += productItem.getProduct().getDiscountedPrice() * productItem.getAmount();
        }

        return promotedPrice + remainingProductsPrice;
    }

    private double applyPromo(Cart cart){
        double totalPromotedPrice = 0;
        //Get promo list
        List<Promo> promoList = this.promoRepository.getPromoList();
        //Get each promo and apply to the cart
        for(Promo promo : promoList) {
            IPromoService promotionService;
            if(promo.isBundledPromo()){
                promotionService = new BundledPromoService();
            }else{
                promotionService = new SingleProductPromoService();
            }
            totalPromotedPrice += promotionService.calculatePromotedPrice(cart, promo);
        }

        return totalPromotedPrice;
    }
}
