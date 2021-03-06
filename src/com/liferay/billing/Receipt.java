package com.liferay.billing;

import com.liferay.products.Product;

import java.util.List;
import java.util.Locale;

public class Receipt {
	private final List<Product> products;
	private double total;
	private double totalSalesTax;

	public Receipt(List<Product> products, double total, double totalSalesTax) {
		this.products = products;
		this.total = total;
		this.totalSalesTax = totalSalesTax;
	}

	public List<Product> getProducts() {
		return products;
	}

	public double getTotal() {
		return total;
	}

	public double getTotalSalesTax() {
		return totalSalesTax;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Product product : products) {
			sb.append(product);
			sb.append("\n");
		}

		sb.append("Sales Taxes: ");
		sb.append(formatValue(totalSalesTax));
		sb.append("\n");
		sb.append("Total: ");
		sb.append(formatValue(total));
		sb.append("\n");

		return sb.toString();
	}

	private String formatValue(double value) {
		return String.format(Locale.US, "%.2f", value);
	}
}
