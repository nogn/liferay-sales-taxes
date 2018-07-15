package com.liferay.billing;

import com.liferay.products.Product;

import java.util.List;

public class PaymentCounter {
    TaxCalculator taxCalculator;

    public PaymentCounter() {
        taxCalculator = new TaxCalculator();
    }

    public Receipt createReceipt(List<Product> products) {
        double totalCost = 0;
        double totalSalesTax = 0;

        for (Product product : products) {
            double taxValue = taxCalculator.calculateTaxValue(product);
            product.setTaxValue(taxValue);

            totalCost += product.getTaxedPrice();
            totalSalesTax += product.getTaxValue();
        }

        return new Receipt(products, totalCost, totalSalesTax);
    }
}
