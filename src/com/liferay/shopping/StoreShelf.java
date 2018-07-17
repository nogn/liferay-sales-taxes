package com.liferay.shopping;

import com.liferay.products.Product;
import com.liferay.products.ProductFactory;
import com.liferay.products.ProductType;

import java.util.HashMap;
import java.util.Map;

public class StoreShelf implements IStoreShelf {

	private final Map<String, ProductType> shelfProducts;

	public StoreShelf() {
		shelfProducts = new HashMap<String, ProductType>();
		registerAvailableProducts();
	}

	private void registerAvailableProducts() {
		shelfProducts.put("book", ProductType.BOOK);
		shelfProducts.put("chocolate bar", ProductType.FOOD);
		shelfProducts.put("box of chocolates", ProductType.FOOD);
		shelfProducts.put("packet of headache pills", ProductType.MEDICAL);
		shelfProducts.put("music CD", ProductType.MISCELLANEOUS);
		shelfProducts.put("bottle of perfume", ProductType.MISCELLANEOUS);
	}

	public Product getProduct(String name, double value, int quantity, boolean imported)
			throws ProductNotAvailableException {
		if (isProductAvailable(name)) {
			ProductType type = getProductType(name);
			return ProductFactory.createProduct(type, name, value, quantity, imported);
		} else {
			throw new ProductNotAvailableException("Product '" + name + "' is not available.");
		}
	}

	private boolean isProductAvailable(String name) {
		return shelfProducts.containsKey(name);
	}

	private ProductType getProductType(String name) {
		return shelfProducts.get(name);
	}
}
