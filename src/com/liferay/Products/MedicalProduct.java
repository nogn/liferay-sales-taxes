package com.liferay.products;

public class MedicalProduct extends Product {

    public MedicalProduct() {
        super();
    }

    public MedicalProduct(String description, double value, int quantity, boolean imported) {
        super(description, value, quantity, imported);
    }

    @Override
    public double getTaxRate() {
        return 0;
    }
}
