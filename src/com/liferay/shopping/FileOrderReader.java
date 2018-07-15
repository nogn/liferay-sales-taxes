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

    public List<Product> getOrderList(String filePath) {
        List<Product> products = new ArrayList<Product>();

        try(Scanner scanner = new Scanner(new FileReader(filePath)))
        {
            while(scanner.hasNext()) {
                Product newProduct = readNewProduct(scanner);
                products.add(newProduct);
            }
        } catch (FileNotFoundException e){
            System.out.println("The given file " + filePath + " was not found.");
        }

        return products;
    }

    private Product readNewProduct(Scanner scanner) {
        int quantity = scanner.nextInt();

        String[] descValue = scanner.nextLine().split(" at ");
        double value = Double.parseDouble(descValue[1]);

        String description = descValue[0].trim();
        boolean imported = description.contains("imported");
        String name = imported ? description.substring(9) : description;

        return storeShelf.getProduct(name, value, quantity, imported);
    }
}
