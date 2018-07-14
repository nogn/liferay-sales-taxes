package com.liferay.shopping;

import com.liferay.products.Product;
import com.liferay.products.ProductFactory;
import com.liferay.products.ProductType;

import java.util.HashMap;
import java.util.Map;

public class StoreShelf {

    private final Map<String, ProductType> shelfProducts;

    public StoreShelf() {
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

    public Product getProduct(String name) {
        ProductType type = this.shelfProducts.get(name);
        Product product = ProductFactory.createProduct(type);

        return product;
    }
}
