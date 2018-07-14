package com.liferay.shopping;

import com.liferay.products.Product;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOrderReader extends OrderReader {

    public FileOrderReader() {
        super();
    }

    public List<Product> getOrderList(String path) {
        List<Product> products = new ArrayList<Product>();

        try(Scanner scanner = new Scanner(new FileReader(path)))
        {
            while(scanner.hasNext()) {
                readNewProduct(scanner, products);
            }
        } catch (FileNotFoundException e){
            System.out.println("The given file " + path + " was not found.");
        }

        return products;
    }

    private void readNewProduct(Scanner scanner, List<Product> products) {
        int quantity = scanner.nextInt();

        String[] descValue = scanner.nextLine().split(" at ");
        double value = Double.parseDouble(descValue[1]);

        String description = descValue[0].trim();
        boolean imported = description.contains("imported");
        String name = imported ? description.substring(9) : description;

        Product product = buildNewProduct(name, value, quantity, imported);
        products.add(product);
    }

    private Product buildNewProduct(String name, double value, int quantity, boolean imported) {
        Product product = this.storeShelf.getProduct(name);

        product.setName(name);
        product.setValue(value);
        product.setQuantity(quantity);
        product.setImported(imported);

        return product;
    }
}
