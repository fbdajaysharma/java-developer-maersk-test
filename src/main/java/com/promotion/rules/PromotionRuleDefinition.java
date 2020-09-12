/*
 * we can create rules here if required in future
 */
package com.promotion.rules;

import com.promotion.pojos.Cart;
import com.promotion.pojos.ProductItem;

public class PromotionRuleDefinition {

    /**
     * buy n items of sku for fixed price.
     *
     * @return Ongoing Promotion
     * 3 of A's for 130
     * 2 of B's for 45
     * <p>
     * As given in problem statement assuming promotions are mutually exclusive
     */
    public static Rule<Integer, Object, Exception> nItemRule() {
        return (Object... fact) -> {
            ProductItem prodItem = (ProductItem) fact[0];
            //System.out.println("product: "+ prodItem.getProduct().getSkuId());
            int totalAmount = 0;
            for (NItemEnum itemEnum : NItemEnum.values()) {
                if (prodItem.getProduct().getSkuId() == itemEnum.getSkuId() && prodItem.getQty() >= itemEnum.getQty()) {
                    totalAmount = (prodItem.getQty() / itemEnum.getQty()) * itemEnum.getPrice();
                    totalAmount += (prodItem.getQty() % itemEnum.getQty()) * prodItem.getProduct().getPrice();
                    return totalAmount;
                } else {
                    totalAmount = prodItem.getQty() * prodItem.getProduct().getPrice();
                }
            }
            return totalAmount;
        };
    }

    /**
     * buy C & D combo of sku for fixed price.
     *
     * @return Ongoing Promotion
     * C & D for 30
     * As given in problem statement assuming promotions are mutually exclusive
     */
    public static Rule<Integer, Object, Exception> comboRule() {
        return (Object... fact) -> {
            int totalAmount ;
            Cart cart = (Cart)fact[0];
            int cQty = 0;
            int cPrice = 0;
            int dQty = 0;
            int dPrice = 0;
            for(ProductItem prodItem: cart.getCartItems()){
                //System.out.println("product: "+ prodItem.getProduct().getSkuId());
                if(prodItem.getProduct().getSkuId() == 'C'){
                    cQty = prodItem.getQty();
                    cPrice = prodItem.getProduct().getPrice();
                }
                else if(prodItem.getProduct().getSkuId() == 'D'){
                    dQty = prodItem.getQty();
                    dPrice = prodItem.getProduct().getPrice();
                }
            }
            if(cQty == dQty){
                totalAmount = dQty * 30;        //combo price
                //System.out.println("in if: "+ dQty);
            }
            //if C and D are in combo and yet one of C or D has more quantity
            else if(cQty > dQty){
                totalAmount = (cQty - dQty) * cPrice + dQty * 30;
            }
            else{
                totalAmount = (dQty - cQty) * dPrice + cQty * 30;
            }

            return totalAmount;
        };
    }

}
