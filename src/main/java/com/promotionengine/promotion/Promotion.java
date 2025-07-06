package com.promotionengine.promotion;

import com.promotionengine.model.Cart;

public interface Promotion {
    boolean isApplicable(Cart cart);
    int apply(Cart cart);
}
