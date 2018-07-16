package com.liferay.billing;

import com.liferay.products.FoodProduct;
import com.liferay.products.MiscellaneousProduct;
import com.liferay.products.Product;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {

    @Test
    public void toStringTest() {
        Product product1 = new FoodProduct("chocolate bar", 10.00, 2, true);
        product1.setTaxValue(1);

        Product product2 = new MiscellaneousProduct("music CD", 47.50, 4, false);
        product2.setTaxValue(19);

        List<Product> productList = Arrays.asList(product1, product2);

        Receipt receipt = new Receipt(productList, 230.0, 20);

        StringBuilder sb = new StringBuilder();

        sb.append("2 imported chocolate bar: 21.00").append("\n");
        sb.append("4 music CD: 209.00").append("\n");
        sb.append("Sales Taxes: 20.00").append("\n");
        sb.append("Total: 230.00").append("\n");

        String receiptStr = receipt.toString();

        assertEquals(sb.toString(), receiptStr);
    }
}
