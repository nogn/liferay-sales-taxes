package com.liferay.billing;

import com.liferay.products.BookProduct;
import com.liferay.products.MedicalProduct;
import com.liferay.products.Product;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentCounterTest {

    @Test
    public void createReceiptTest() {
        Product product1 = new BookProduct();
        product1.setValue(5.0);
        product1.setQuantity(1);

        Product product2 = new MedicalProduct();
        product2.setValue(2.5);
        product2.setQuantity(2);

        List<Product> products = Arrays.asList(product1, product2);
        
        double expectedTotalCost = 10.0;
        double expectedTotalTax = 0.0;

        PaymentCounter paymentCounter = new PaymentCounter();
        
        Receipt receipt = paymentCounter.createReceipt(products);

        assertNotNull(receipt);
        assertEquals(expectedTotalCost, receipt.getTotal());
        assertEquals(expectedTotalTax, receipt.getTotalSalesTax());
        assertEquals(0, product1.getTaxValue());
        assertEquals(0, product2.getTaxValue());
    }
}
