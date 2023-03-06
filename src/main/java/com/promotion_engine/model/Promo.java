package com.promotion_engine.model;

import java.util.List;

public class Promo {
    private List<ProductItem> promotionProductItemList;
    private double promoPrice;
    private boolean bundledPromo;

    public Promo(List<ProductItem> promotionProductItemList, double promoPrice, boolean bundledPromo) {
        this.promotionProductItemList = promotionProductItemList;
        this.promoPrice = promoPrice;
        this.bundledPromo = bundledPromo;
    }

    public List<ProductItem> getPromotionProductItemList() {
        return promotionProductItemList;
    }

    public void setPromotionProductItemList(List<ProductItem> promotionProductItemList) {
        this.promotionProductItemList = promotionProductItemList;
    }

    public double getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(double promoPrice) {
        this.promoPrice = promoPrice;
    }

    public boolean isBundledPromo() {
        return bundledPromo;
    }

    public void setBundledPromo(boolean bundledPromo) {
        this.bundledPromo = bundledPromo;
    }
}
