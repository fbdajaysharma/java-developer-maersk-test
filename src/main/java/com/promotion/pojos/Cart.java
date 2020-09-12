package com.promotion.pojos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ajay Kumar
 * Cart class for holding Products with quantity
 */
public class Cart {
    private List<ProductItem> cartItems = new ArrayList<>();

    public List<ProductItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ProductItem> cartItems) {
        this.cartItems = cartItems;
    }
}
