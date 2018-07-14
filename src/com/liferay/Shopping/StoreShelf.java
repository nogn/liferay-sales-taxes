package com.liferay.Shopping;

import com.liferay.Products.Product;
import com.liferay.Products.ProductFactory;
import com.liferay.Products.ProductType;

import java.util.HashMap;
import java.util.Map;

public class StoreShelf {

    private ProductFactory factory;
    private final Map<String, ProductType> shelfProducts;

    public StoreShelf() {
        factory = new ProductFactory();
        this.shelfProducts = new HashMap<String, ProductType>();
        this.registerAvailableProducts();
    }

    private void registerAvailableProducts() {
        this.shelfProducts.put("book", ProductType.BOOK);
        this.shelfProducts.put("chocolate bar", ProductType.FOOD);
        this.shelfProducts.put("box of chocolates", ProductType.FOOD);
        this.shelfProducts.put("packet of headache pills", ProductType.MEDICAL);
        this.shelfProducts.put("music CD", ProductType.MISCELLANEOUS);
        this.shelfProducts.put("bottle of perfume", ProductType.MISCELLANEOUS);
    }

    public StoreShelf(Map<String, ProductType> shelfProducts) {
        this.shelfProducts = shelfProducts;
    }

    public Product getProduct(String name, double value, int quantity, boolean imported) {
        ProductType type = this.shelfProducts.get(name);

        Product product = this.factory.getProduct(type);
        product.setName(name);
        product.setValue(value);
        product.setQuantity(quantity);
        product.setImported(imported);

        return product;
    }
}
