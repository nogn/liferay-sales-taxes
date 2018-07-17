package com.liferay.billing;

import com.liferay.products.Product;

import java.util.List;

public interface IPaymentCounter {
	Receipt createReceipt(List<Product> products);
}
