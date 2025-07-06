package com.promotionengine;

import com.promotionengine.model.*;
import com.promotionengine.promotion.*;
import com.promotionengine.engine.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class PromotionEngineTest {

    private PromotionEngine buildEngine() {
        List<Promotion> promos = new ArrayList<>();
        promos.add(new BulkPromotion("A", 3, 130));
        promos.add(new BulkPromotion("B", 2, 45));
        promos.add(new ComboPromotion("C", "D", 30));
        return new PromotionEngine(promos);
    }

    @Test
    void testScenarioA() {
        Cart cart = new Cart();
        cart.addItem(new CartItem("A", 1, 50));
        cart.addItem(new CartItem("B", 1, 30));
        cart.addItem(new CartItem("C", 1, 20));
        int total = buildEngine().calculateTotal(cart);
        assertEquals(100, total);
    }

    @Test
    void testScenarioB() {
        Cart cart = new Cart();
        cart.addItem(new CartItem("A", 5, 50));
        cart.addItem(new CartItem("B", 5, 30));
        cart.addItem(new CartItem("C", 1, 20));
        int total = buildEngine().calculateTotal(cart);
        assertEquals(370, total);
    }

    @Test
    void testScenarioC() {
        Cart cart = new Cart();
        cart.addItem(new CartItem("A", 3, 50));
        cart.addItem(new CartItem("B", 5, 30));
        cart.addItem(new CartItem("C", 1, 20));
        cart.addItem(new CartItem("D", 1, 15));
        int total = buildEngine().calculateTotal(cart);
        assertEquals(280, total);
    }
}
