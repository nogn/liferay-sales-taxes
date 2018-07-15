package com.liferay.shopping;

import com.liferay.billing.PaymentCounter;
import com.liferay.billing.Receipt;
import com.liferay.products.Product;

import java.util.List;

public class ShoppingStore {
    private static ShoppingStore instance;

    private OrderReader orderReader;
    private PaymentCounter paymentCounter;

    private ShoppingStore() {
        orderReader = new FileOrderReader();
        paymentCounter = new PaymentCounter();
    }

    public static ShoppingStore getInstance() {
    	if (instance == null)
    		 instance = new ShoppingStore();
    	
        return instance;
    }

    public void processSalesOrderAndCreateReceipt(String filePath) {
    	List<Product> orderList = orderReader.getOrderList(filePath);
    	Receipt receipt = paymentCounter.createReceipt(orderList);
    	outputReceipt(receipt);
    }

    private void outputReceipt(Receipt receipt) {
        System.out.println(receipt);
    }
}
