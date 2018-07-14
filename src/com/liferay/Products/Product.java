package com.liferay.Products;

public abstract class Product {
    String name;
    double value;
    int quantity;
    boolean imported;

    public Product() { }

    public Product(String description, double value, int quantity, boolean imported) {
        this.name = description;
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

    public abstract double getTaxRate();

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", quantity=" + quantity +
                ", imported=" + imported +
                '}';
    }
}
