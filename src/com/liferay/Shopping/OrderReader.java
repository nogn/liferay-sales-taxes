package com.liferay.Shopping;

import com.liferay.Products.Product;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderReader {
    StoreShelf storeShelf;

    public OrderReader() {
        this.storeShelf = new StoreShelf();
    }

    public List<Product> getOrderList(String fileName) throws FileNotFoundException {
        List<Product> products = new ArrayList<Product>();

        Scanner scanner = new Scanner(new FileReader(fileName));

        while(scanner.hasNext()) {
            int quantity = scanner.nextInt();

            String[] descValue = scanner.nextLine().split(" at ");
            double value = Double.parseDouble(descValue[1]);

            String description = descValue[0].trim();
            boolean imported = description.contains("imported");
            String name = imported ? description.substring(9) : description;

            Product product = this.storeShelf.getProduct(name, value, quantity, imported);
            products.add(product);
        }

        return products;
    }
}
