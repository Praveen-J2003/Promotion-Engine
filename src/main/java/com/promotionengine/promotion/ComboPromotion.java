package com.promotionengine.promotion;

import com.promotionengine.model.*;

public class ComboPromotion implements Promotion {
    private String sku1;
    private String sku2;
    private int promoPrice;

    public ComboPromotion(String sku1, String sku2, int promoPrice) {
        this.sku1 = sku1;
        this.sku2 = sku2;
        this.promoPrice = promoPrice;
    }

    @Override
    public boolean isApplicable(Cart cart) {
        CartItem item1 = cart.getItemBySku(sku1);
        CartItem item2 = cart.getItemBySku(sku2);
        return item1 != null && item2 != null && item1.quantity > 0 && item2.quantity > 0;
    }

    @Override
    public int apply(Cart cart) {
        CartItem item1 = cart.getItemBySku(sku1);
        CartItem item2 = cart.getItemBySku(sku2);
        if (item1 == null || item2 == null) return 0;
        int count = Math.min(item1.quantity, item2.quantity);
        int total = count * promoPrice;
        item1.quantity -= count;
        item2.quantity -= count;
        return total;
    }
}
