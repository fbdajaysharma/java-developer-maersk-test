package com.promotion;

import com.promotion.pojos.Cart;
import com.promotion.pojos.Product;
import com.promotion.pojos.ProductItem;
import com.promotion.rules.PromotionEngine;
import com.promotion.rules.PromotionRuleDefinition;
import com.promotion.rules.RuleExecution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainProgram {
    public static void main(String[] args) {

        int totalOrderValue = 0;
        //values initialized based on given problem statement;
        Product pa = new Product('A', 50);
        Product pb = new Product('B', 30);
        Product pc = new Product('C', 20);
        Product pd = new Product('D', 15);

        ProductItem prodItemA = new ProductItem(pa, 3);
        ProductItem prodItemB = new ProductItem(pb, 5);
        ProductItem prodItemC = new ProductItem(pc, 2);
        ProductItem prodItemD = new ProductItem(pd, 2);

        List<ProductItem> productList = Arrays.asList(prodItemA, prodItemB, prodItemC, prodItemD);

        Cart cart = new Cart();
        cart.setCartItems(productList);

        System.out.print("Final cart amount is: "+ totalOrderValue);
        //with this input set output will be 310
    }
}
