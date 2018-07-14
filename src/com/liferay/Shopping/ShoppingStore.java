package com.liferay.shopping;

import com.liferay.billing.PaymentCounter;
import com.liferay.billing.Receipt;
import com.liferay.products.Product;

import java.util.List;

public class ShoppingStore {
    private static ShoppingStore instance = new ShoppingStore();

    private OrderReader orderReader;
    private ShoppingCart cart;
    private PaymentCounter paymentCounter;

    private ShoppingStore() {
        this.orderReader = new FileOrderReader();
        this.cart = new ShoppingCart();
        this.paymentCounter = new PaymentCounter();
    }

    public static ShoppingStore getInstance() {
        return instance;
    }

    public void getSalesOrderAndCheckout(String fileName) {
        this.getSalesOrder(fileName);
        this.checkout();
    }

    private void getSalesOrder(String fileName) {
        List<Product> orderList = orderReader.getOrderList(fileName);
        cart.addProducts(orderList);
    }

    private void checkout() {
        Receipt receipt = paymentCounter.createReceipt(this.cart.getProducts());
        outputReceipt(receipt);
        cart.clearCart();
    }

    private void outputReceipt(Receipt receipt) {
        System.out.println(receipt);
    }
}
