package com.liferay.products;

import java.util.Locale;

public abstract class Product {
	private String name;
	private double value;
	private int quantity;
	private boolean imported;
	private double taxValue;

	public Product() {
	}

	public Product(String name, double value, int quantity, boolean imported) {
		this.name = name;
		this.value = value;
		this.quantity = quantity;
		this.imported = imported;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public double getTaxValue() {
		return taxValue;
	}

	public void setTaxValue(double taxValue) {
		this.taxValue = taxValue;
	}

	public double getPrice() {
		return getQuantity() * getValue();
	}

	public double getTaxedPrice() {
		return getPrice() + taxValue;
	}

	public abstract double getTaxRate();

	@Override
	public String toString() {
		String formattedTaxedPrice = String.format(Locale.US, "%.2f", getTaxedPrice());
		return getQuantity() + (isImported() ? " imported " : " ") + getName() + ": " + formattedTaxedPrice;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Product))
			return false;

		Product product = (Product) obj;

		return product.getValue() == this.getValue() && product.getName().equals(this.getName())
				&& product.getQuantity() == this.getQuantity() && product.isImported() == this.isImported()
				&& product.getTaxValue() == this.getTaxValue();
	}
}
