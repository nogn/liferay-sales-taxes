package com.liferay.shopping;

import com.liferay.products.Product;

public interface IStoreShelf {
	Product getProduct(String name, double value, int quantity, boolean imported) throws ProductNotAvailableException;
}
