package com.liferay.products;

public class FoodProduct extends Product {
    public FoodProduct() {
        super();
    }

    public FoodProduct(String description, double value, int quantity, boolean imported) {
        super(description, value, quantity, imported);
    }

    @Override
    public double getTaxRate() {
        return 0;
    }
}
