package com.liferay.products;

public class ProductFactory {

    public static Product createProduct(ProductType type) {
        Product product = null;

        if (type == ProductType.BOOK)
            product = new BookProduct();
        else if (type == ProductType.FOOD)
            product = new FoodProduct();
        else if (type == ProductType.MEDICAL)
            product = new MedicalProduct();
        else if (type == ProductType.MISCELLANEOUS)
            product = new MiscellaneousProduct();

        return product;
    }
}
