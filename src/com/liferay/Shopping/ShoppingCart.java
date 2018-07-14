package com.liferay.shopping;

import com.liferay.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void clearCart() {
        products.clear();
    }
}
