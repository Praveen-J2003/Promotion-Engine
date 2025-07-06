package com.promotionengine.promotion;

import com.promotionengine.model.*;

public class BulkPromotion implements Promotion {
    private String sku;
    private int requiredQuantity;
    private int promoPrice;

    public BulkPromotion(String sku, int requiredQuantity, int promoPrice) {
        this.sku = sku;
        this.requiredQuantity = requiredQuantity;
        this.promoPrice = promoPrice;
    }

    @Override
    public boolean isApplicable(Cart cart) {
        CartItem item = cart.getItemBySku(sku);
        return item != null && item.quantity >= requiredQuantity;
    }

    @Override
    public int apply(Cart cart) {
        CartItem item = cart.getItemBySku(sku);
        if (item == null) return 0;
        int count = item.quantity / requiredQuantity;
        int remainder = item.quantity % requiredQuantity;
        int total = count * promoPrice + remainder * item.unitPrice;
        item.quantity = 0; // Mark processed
        return total;
    }
}
