package com.promotionengine;

import com.promotionengine.model.*;
import com.promotionengine.promotion.*;
import com.promotionengine.engine.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addItem(new CartItem("A", 3, 50));
        cart.addItem(new CartItem("B", 5, 30));
        cart.addItem(new CartItem("C", 1, 20));
        cart.addItem(new CartItem("D", 1, 15));

        List<Promotion> promotions = new ArrayList<>();
        promotions.add(new BulkPromotion("A", 3, 130));
        promotions.add(new BulkPromotion("B", 2, 45));
        promotions.add(new ComboPromotion("C", "D", 30));

        PromotionEngine engine = new PromotionEngine(promotions);
        int total = engine.calculateTotal(cart);

        System.out.println("Total cart value after applying promotions: " + total);
    }
}
