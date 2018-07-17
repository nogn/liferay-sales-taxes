package com.liferay.products;

public class ProductFactory {

    public static Product createProduct(ProductType type, String name, double value, int quantity, boolean imported) {
        Product product = null;

        if (type == ProductType.BOOK)
            product = new BookProduct(name, value, quantity, imported);
        else if (type == ProductType.FOOD)
            product = new FoodProduct(name, value, quantity, imported);
        else if (type == ProductType.MEDICAL)
            product = new MedicalProduct(name, value, quantity, imported);
        else if (type == ProductType.MISCELLANEOUS)
            product = new MiscellaneousProduct(name, value, quantity, imported);

        return product;
    }
}
