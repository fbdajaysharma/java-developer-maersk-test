package com.promotion.rules;

/*
* This enum can be updated based on the requirement for n item rule
* currently we have SKU A with 3 qty for 130
* SKU B with 2 qty for 45
*
* Similarly if more requirement comes in please updated the enum
 */
public enum NItemEnum {
    A('A',3, 130), B('B',2, 45);

    private char skuId;
    private int qty;
    private int price;

    NItemEnum(char skuId, int qty, int price) {
        this.skuId = skuId;
        this.qty = qty;
        this.price = price;
    }

    public char getSkuId() {
        return skuId;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }
}
