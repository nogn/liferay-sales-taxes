package com.liferay.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductFactoryTest {

	@Test
	public void createBookProductTest() {
		ProductType type = ProductType.BOOK;
		String name = "Game of Thrones";
		double value = 99.99;
		int quantity = 2;
		boolean imported = true;

		Product expectedProduct = new BookProduct(name, value, quantity, imported);

		Product product = ProductFactory.createProduct(type, name, value, quantity, imported);
		
		assertNotNull(product);
		assertEquals(expectedProduct, product);
	}

	@Test
	public void createFoodProductTest() {
		ProductType type = ProductType.FOOD;
		String name = "Hamburguer";
		double value = 9.99;
		int quantity = 1;
		boolean imported = false;

		Product expectedProduct = new FoodProduct(name, value, quantity, imported);
				
		Product product = ProductFactory.createProduct(type, name, value, quantity, imported);
		
		assertNotNull(product);
		assertEquals(expectedProduct, product);
	}
	
	@Test
	public void createMedicalProductTest() {
		ProductType type = ProductType.MEDICAL;
		String name = "Pills";
		double value = 1.99;
		int quantity = 10;
		boolean imported = true;

		Product expectedProduct = new MedicalProduct(name, value, quantity, imported);

		Product product = ProductFactory.createProduct(type, name, value, quantity, imported);
		
		assertNotNull(product);
		assertEquals(expectedProduct, product);
	}
	
	@Test
	public void createMiscellaneousProductTest() {
		ProductType type = ProductType.MISCELLANEOUS;
		String name = "Headphone";
		double value = 50.0;
		int quantity = 1;
		boolean imported = false;

		Product expectedProduct = new MiscellaneousProduct(name, value, quantity, imported);

		Product product = ProductFactory.createProduct(type, name, value, quantity, imported);
		
		assertNotNull(product);
		assertEquals(expectedProduct, product);
	}
	
	@Test
	public void notCreateInvalidProductTest() {
		ProductType type = null;
		String name = "Undefined";
		double value = 20.0;
		int quantity = 1;
		boolean imported = false;
				
		Product product = ProductFactory.createProduct(type, name, value, quantity, imported);
		
		assertNull(product);
	}
}
