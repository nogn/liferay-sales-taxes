package com.liferay.products;

public class MiscellaneousProduct extends Product {

    public MiscellaneousProduct() {
        super();
    }

    public MiscellaneousProduct(String description, double value, int quantity, boolean imported) {
        super(description, value, quantity, imported);
    }

    @Override
    public double getTaxRate() {
        return 0.1;
    }
}
