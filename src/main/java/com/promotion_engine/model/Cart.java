package com.promotion_engine.model;

import java.util.List;

public class Cart {
    private List<ProductItem> productItems;

    public Cart(List<ProductItem> productItems) {
        this.productItems = productItems;
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
    }

    //Find matching product items
    public ProductItem findProductItem(ProductItem productItem) {
        for(ProductItem cartProductItem : this.productItems) {
            if(productItem.getProduct().getSku().equals(cartProductItem.getProduct().getSku())) {
                return cartProductItem;
            }
        }
        return null;
    }
}
