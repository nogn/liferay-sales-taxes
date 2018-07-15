package com.liferay.billing;

import com.liferay.products.Product;

import static com.liferay.billing.TaxType.IMPORT_TAX;

public class TaxCalculator {
    private static final double ROUND_OFF = 0.05;

    public double calculateTaxValue(Product product) {
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
        return Math.ceil(value / ROUND_OFF) * ROUND_OFF;
    }
}
