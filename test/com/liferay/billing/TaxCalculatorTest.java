package com.liferay.billing;

import com.liferay.products.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxCalculatorTest {

	@Test
	public void calculateTaxValueForBookProductTest() {
		BookProduct product = new BookProduct();
		product.setQuantity(1);
		product.setValue(12.49);
		product.setImported(false);

		double expectedTaxValue = 0;

		TaxCalculator taxCalculator = new TaxCalculator();
		double taxValue = taxCalculator.calculateTaxValue(product);

		assertEquals(expectedTaxValue, taxValue, 0.001);
	}

	@Test
	public void calculateTaxValueForMedicalProductTest() {
		MedicalProduct product = new MedicalProduct();
		product.setQuantity(1);
		product.setValue(9.75);
		product.setImported(false);

		double expectedTaxValue = 0;

		TaxCalculator taxCalculator = new TaxCalculator();
		double taxValue = taxCalculator.calculateTaxValue(product);

		assertEquals(expectedTaxValue, taxValue, 0.001);
	}

	@Test
	public void calculateTaxValueForFoodProductTest() {
		FoodProduct product = new FoodProduct();
		product.setQuantity(2);
		product.setValue(11.25);
		product.setImported(false);

		double expectedTaxValue = 0;

		TaxCalculator taxCalculator = new TaxCalculator();
		double taxValue = taxCalculator.calculateTaxValue(product);

		assertEquals(expectedTaxValue, taxValue, 0.001);
	}

	@Test
	public void calculateTaxValueForMiscellaneousProductTest() {
		MiscellaneousProduct product = new MiscellaneousProduct();
		product.setQuantity(1);
		product.setValue(18.99);
		product.setImported(false);

		double expectedTaxValue = 1.9;

		TaxCalculator taxCalculator = new TaxCalculator();
		double taxValue = taxCalculator.calculateTaxValue(product);

		assertEquals(expectedTaxValue, taxValue, 0.001);
	}

	@Test
	public void calculateTaxValueForImportedProductTest() {
		MiscellaneousProduct product = new MiscellaneousProduct();
		product.setQuantity(1);
		product.setValue(47.50);
		product.setImported(true);

		double expectedTaxValue = 7.15;

		TaxCalculator taxCalculator = new TaxCalculator();
		double taxValue = taxCalculator.calculateTaxValue(product);

		assertEquals(expectedTaxValue, taxValue, 0.001);
	}

	@Test
	public void calculateRoundedOffTaxValueTest() {
		FoodProduct product = new FoodProduct();
		product.setQuantity(1);
		product.setValue(11.25);
		product.setImported(true);

		double expectedTaxValue = 0.6;

		TaxCalculator taxCalculator = new TaxCalculator();
		double taxValue = taxCalculator.calculateTaxValue(product);

		assertEquals(expectedTaxValue, taxValue, 0.001);
	}
}
