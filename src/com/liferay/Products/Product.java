package com.liferay.products;

public abstract class Product {
    private String name;
    private double value;
    private int quantity;
    private boolean imported;
    private double taxValue;

    public Product() { }

    public Product(String name, double value, int quantity, boolean imported) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.imported = imported;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

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

    public boolean isImported() { return imported; }

    public void setImported(boolean imported) { this.imported = imported; }

    public double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(double taxValue) {
        this.taxValue = taxValue;
    }

    public double getPrice() {
        return this.getQuantity() * this.getValue();
    }

    public double getTaxedPrice() {
        return this.getPrice() + this.taxValue;
    }

    public abstract double getTaxRate();

    @Override
    public String toString() {
        String formattedTaxedPrice = String.format("%.2f", this.getTaxedPrice());
        return this.getQuantity() + (this.isImported() ? " imported " : " ") + this.getName() + ": " + formattedTaxedPrice;
    }
}
