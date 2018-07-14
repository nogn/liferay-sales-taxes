package com.liferay.shopping;

import com.liferay.products.Product;

import java.util.List;

public abstract class OrderReader {
    StoreShelf storeShelf;

    public OrderReader() {
        this.storeShelf = new StoreShelf();
    }

    abstract List<Product> getOrderList(String path);
}
