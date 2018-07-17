package com.liferay.shopping;

import com.liferay.billing.IPaymentCounter;
import com.liferay.billing.PaymentCounter;
import com.liferay.billing.Receipt;
import com.liferay.billing.TaxCalculator;
import com.liferay.products.Product;

import java.util.List;

public class ShoppingStore {
    private static ShoppingStore instance;

    private OrderReader orderReader;
    private IPaymentCounter paymentCounter;

    private ShoppingStore() {
        orderReader = new FileOrderReader();
        paymentCounter = new PaymentCounter();
    }

    public static ShoppingStore getInstance() {
    	if (instance == null)
    		 instance = new ShoppingStore();
    	
        return instance;
    }

    public void processOrderAndCreateReceipt(String filePath) {
    	List<Product> orderList = orderReader.getOrderList(filePath);

    	if (!orderList.isEmpty()) {
            Receipt receipt = paymentCounter.createReceipt(orderList);
            System.out.println(receipt);
        } else {
    	    System.out.println("Invalid order\n");
        }
    }
}
