package com.liferay.products;

import static com.liferay.billing.TaxType.BASIC_TAX;

public class MiscellaneousProduct extends Product {

    public MiscellaneousProduct() {
        super();
    }

    public MiscellaneousProduct(String description, double value, int quantity, boolean imported) {
        super(description, value, quantity, imported);
    }

    @Override
    public double getTaxRate() {
        return BASIC_TAX;
    }
}
