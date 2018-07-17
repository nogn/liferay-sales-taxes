package com.liferay.billing;

import com.liferay.products.Product;

public interface ITaxCalculator {
	double calculateTaxValue(Product product);
}
