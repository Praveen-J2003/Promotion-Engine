package com.promotionengine.model;

public class CartItem {
    public String sku;
    public int quantity;
    public int unitPrice;

    public CartItem(String sku, int quantity, int unitPrice) {
        this.sku = sku;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}
