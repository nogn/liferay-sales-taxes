package com.liferay.shopping;

import com.liferay.products.Product;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
                try {
                    Product newProduct = readNewProduct(scanner);
                    products.add(newProduct);
                } catch (ProductNotAvailableException e) {
                    System.out.println(e.getMessage());
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Invalid input entry.");
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("The file " + filePath + " was not found.");
        }

        return products;
    }

    private Product readNewProduct(Scanner scanner) throws InputMismatchException, ProductNotAvailableException {
		int quantity = readProductQuantity(scanner);
        
		String[] descValue = readProductDescriptionAndValue(scanner);
        String description = descValue[0].trim();
        String valueStr = descValue[1].trim();
		
		boolean imported = readProductImported(description);
        String name = readProductName(imported, description);
        double value = readProductValue(valueStr);
        
        return storeShelf.getProduct(name, value, quantity, imported);
    }
    
    private int readProductQuantity(Scanner scanner) throws InputMismatchException {
    	int quantity = scanner.nextInt();
    	
        if (quantity <= 0) {
        	scanner.nextLine();
        	throw new InputMismatchException();
        }
        
        return quantity;
    }
    
    private String[] readProductDescriptionAndValue(Scanner scanner) throws InputMismatchException {
    	String nextLine = scanner.nextLine();
        
    	if (!nextLine.contains(" at "))
            throw new InputMismatchException();
    	
    	return nextLine.split(" at ");
    }
    
    private boolean readProductImported(String description) {
    	return description.contains("imported");
    }
    
    private String readProductName(boolean imported, String description) throws InputMismatchException {
    	String name = imported ? description.split("imported ")[1] : description;
    	
    	if (name.isEmpty())
        	throw new InputMismatchException();
    	
    	return name;
    }
    
    private double readProductValue(String valueStr) throws InputMismatchException {
    	double value = Double.parseDouble(valueStr);
        
    	if (value < 0)
        	throw new InputMismatchException();
    	
    	return value;
    }
}
