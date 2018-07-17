package com.liferay.products;

import static com.liferay.billing.TaxType.EXEMPT_TAX;

public class BookProduct extends Product {

    public BookProduct() {
        super();
    }

    public BookProduct(String description, double value, int quantity, boolean imported) {
        super(description, value, quantity, imported);
    }

    @Override
    public double getTaxRate() {
        return EXEMPT_TAX;
    }
}
