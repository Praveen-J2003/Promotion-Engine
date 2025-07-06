package com.promotionengine.engine;

import com.promotionengine.model.*;
import com.promotionengine.promotion.*;
import java.util.*;

public class PromotionEngine {
    private List<Promotion> promotions;

    public PromotionEngine(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public int calculateTotal(Cart cart) {
        int total = 0;
        for (Promotion promo : promotions) {
            if (promo.isApplicable(cart)) {
                total += promo.apply(cart);
            }
        }
        for (CartItem item : cart.items) {
            if (item.quantity > 0) {
                total += item.quantity * item.unitPrice;
                item.quantity = 0;
            }
        }
        return total;
    }
}
