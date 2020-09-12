package com.promotion;

import com.promotion.pojos.Cart;
import com.promotion.pojos.Product;
import com.promotion.pojos.ProductItem;
import com.promotion.rules.PromotionEngine;
import com.promotion.rules.PromotionRuleDefinition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainProgram {
    public static void main(String[] args) {

        int totalOrderValue = 0;
        //values initialized based on given problem statement;
        Product pa = new Product('A', 50);
        Product pb = new Product('B', 30);
        Product pc = new Product('C', 20);
        Product pd = new Product('D', 15);

        List<ProductItem> productList = new ArrayList<>();

        try {
            int[] inputQty = Stream.of(args).mapToInt(Integer::parseInt).toArray();
            ProductItem prodItemA = new ProductItem(pa, inputQty[0]);
            ProductItem prodItemB = new ProductItem(pb, inputQty[1]);
            ProductItem prodItemC = new ProductItem(pc, inputQty[2]);
            ProductItem prodItemD = new ProductItem(pd, inputQty[3]);

            productList = Arrays.asList(prodItemA, prodItemB, prodItemC, prodItemD);
        }
        catch(Exception e){
            System.out.print("Please give 4 inputs, so simplicity of the application, you can specify 0");
            e.printStackTrace();
        }


        Cart cart = new Cart();
        cart.setCartItems(productList);

        for(ProductItem productItem: cart.getCartItems()){
            try {
                char skuId = productItem.getProduct().getSkuId();
                //skipping this promotion on C and D
                if(skuId != 'C' && skuId != 'D'){
                    totalOrderValue += applyPromotion(productItem);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        //combo C and D and also if C and D are more than combination
        // 1 * C and 2 *D will yield 30+15 = 45 for C and D combo rule
        try {
            totalOrderValue += applyPromotion(cart);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.print("Final cart amount is: "+ totalOrderValue);
        //with this input set output will be 310
    }

    /*
     * accept Product Item as parameter
     */
    private static int applyPromotion(ProductItem prodItem) throws Exception {
        int orderValue = PromotionEngine.run(PromotionEngine.createRuleExecution(PromotionRuleDefinition.nItemRule(), prodItem));

        return orderValue;
    }

    /*
     * accept cart as parameter
     */
    private static int applyPromotion(Cart cart) throws Exception {
        int orderValue = PromotionEngine.run(PromotionEngine.createRuleExecution(PromotionRuleDefinition.comboRule(), cart));

        return orderValue;
    }
}
