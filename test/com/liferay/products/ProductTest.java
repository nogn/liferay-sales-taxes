package com.liferay.products;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class ProductTest {
	
	@Test
	public void getTaxedPriceTest() {
		Product product = new MiscellaneousProduct("chocolate bar", 10.00, 2, false);
		product.setTaxValue(2);
	
		double expectedTaxedPrice = 22;
		
		double taxedPrice = product.getTaxedPrice();
		
		assertEquals(expectedTaxedPrice, taxedPrice, 0.001);
	}
	
	@Test
	public void toStringTest() {
		Product product = new FoodProduct("chocolate bar", 10.00, 2, true);
        product.setTaxValue(1);
		
        String productStr = product.toString();
        
		assertEquals("2 imported chocolate bar: 21.00", productStr);
	}
}
