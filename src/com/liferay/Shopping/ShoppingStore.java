package com.liferay.Shopping;

import com.liferay.Products.Product;

import java.io.FileNotFoundException;
import java.util.List;

public class ShoppingStore {
    private static ShoppingStore instance = new ShoppingStore();
    private ShoppingCart cart;

    private ShoppingStore() {
        this.cart = new ShoppingCart();
    }

    public static ShoppingStore getInstance() {
        return instance;
    }

    public void getSalesOrderAndCheckout(String fileName) throws FileNotFoundException {
        this.getSalesOrder(fileName);
        this.checkout();
    }

    private void getSalesOrder(String fileName) throws FileNotFoundException {
        OrderReader orderReader = new OrderReader();
        List<Product> orderList  = orderReader.getOrderList(fileName);
        cart.addProducts(orderList);
    }

    private void checkout() {
        // TODO
    }
}
