package com.liferay;

import com.liferay.Shopping.ShoppingStore;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ShoppingStore shoppingStore = ShoppingStore.getInstance();

        List<String> fileNames = Arrays.asList("input-files/input1.txt", "input-files/input2.txt", "input-files/input3.txt");

        for (String fileName: fileNames){
            try {
                shoppingStore.getSalesOrderAndCheckout(fileName);
            } catch (FileNotFoundException e){
                System.out.println("The given file " + fileName + " was not found.");
            }
        }
    }
}
