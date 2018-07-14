package com.liferay.Products;

public class ProductFactory {

    public ProductFactory() { }

    public Product getProduct(ProductType type) {
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
