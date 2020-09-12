/**
 * This test class will fail due to compilation error because no class has been created so far
 */
package com.red;

import com.promotion.MainProgram;
import com.promotion.pojos.Cart;
import com.promotion.pojos.Product;
import com.promotion.pojos.ProductItem;
import com.promotion.rules.PromotionEngine;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * @author I0000962
 *
 */
public class RedTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}
	
	@Test
	public void testMain() {
		String[] args = new String[]{"Hello"};
		MainProgram.main(args);
		assertEquals("Final cart amount is: 100", outContent.toString());
	}

	@Test
	public void testCart() {
		Cart cart  = new Cart();
		assertNotNull(cart.getCartItems());
	}

	@Test
	public void testProduct() {
		Product product  = new Product('A', 10);
		assertEquals(product.getPrice(), 10);
	}

	@Test
	public void testProductItem() {
		ProductItem product  = new ProductItem(new Product('A', 10), 10);
		assertEquals(product.getQty(), 10);
		assertNotNull(product.getProduct());
	}

}
