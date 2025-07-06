package com.promotionengine.model;

import java.util.*;

public class Cart {
    public List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        items.add(item);
    }

    public CartItem getItemBySku(String sku) {
        for (CartItem item : items) {
            if (item.sku.equals(sku)) return item;
        }
        return null;
    }
}
