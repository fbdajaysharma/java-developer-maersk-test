package com.green;

import com.promotion.pojos.Cart;
import com.promotion.rules.NItemEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PromotionTests {
    @Test
    public void testEnumClass() {
        Cart cart  = new Cart();
        assertEquals(130, NItemEnum.A.getPrice());
        assertEquals(45, NItemEnum.B.getPrice());
    }
}
