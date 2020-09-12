package com.green;

import com.promotion.pojos.Cart;
import com.promotion.rules.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PromotionTests {
    @Test
    public void testEnumClass() {
        assertEquals(130, NItemEnum.A.getPrice());
        assertEquals(45, NItemEnum.B.getPrice());
    }

    @Test
    public void testRuleDefinition() {
        assertNotNull(PromotionRuleDefinition.nItemRule());
        assertNotNull(PromotionRuleDefinition.comboRule());
    }

    @Test
    public void testPromotionEngine(){
        assertNotNull(PromotionEngine.createRuleExecution(PromotionRuleDefinition.nItemRule()));
    }
}
