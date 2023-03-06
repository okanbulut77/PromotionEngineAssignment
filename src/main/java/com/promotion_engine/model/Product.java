package com.promotion_engine.model;

public class Product {
    private String sku;
    private double unitPrice;
    private double discount;

    public Product(String sku, double unitPrice, double discount) {
        this.sku = sku;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public double getDiscountedPrice() {
        return unitPrice * (1 - discount/100);
    }

}
