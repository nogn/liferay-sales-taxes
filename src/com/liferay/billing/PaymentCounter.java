package com.liferay.billing;

import com.liferay.products.Product;

import java.util.List;

public class PaymentCounter {
    private final double IMPORT_TAX = 0.05;
    
    public Receipt createReceipt(List<Product> products) {
        double total = 0;
        double totalSalesTax = 0;

        for (Product product : products) {
            product.setTaxValue(calculateAndGetTaxValue(product));

            total += product.getTaxedPrice();
            totalSalesTax += product.getTaxValue();
        }

        return new Receipt(products, total, totalSalesTax);
    }

    private double calculateAndGetTaxValue(Product product) {
        double taxValue = product.getTaxRate() * product.getPrice();

        if (product.isImported())
            taxValue += IMPORT_TAX * product.getPrice();

        taxValue = roundOff(taxValue);

        return taxValue;
    }

    /**
     * Rounds off the value to the nearest 0.05
     * @param value
     * @return rounded value
     */
    private double roundOff(double value) {
        return Math.round(value / 0.05) * 0.05;
    }
}
