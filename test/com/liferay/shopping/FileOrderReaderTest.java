package com.liferay.shopping;

import com.liferay.products.FoodProduct;
import com.liferay.products.MiscellaneousProduct;
import com.liferay.products.Product;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FileOrderReaderTest {

	@Test
	public void getOrderListTest() {
		FileOrderReader fileOrderReader = new FileOrderReader();

		Product expected1 = new FoodProduct("chocolate bar", 10.00, 2, true);
		Product expected2 = new MiscellaneousProduct("music CD", 47.50, 4, false);

		List<Product> products = fileOrderReader.getOrderList("input-files/input-test.txt");

		assertNotNull(products);
		assertEquals(2, products.size());
		assertEquals(expected1, products.get(0));
		assertEquals(expected2, products.get(1));
	}
}
