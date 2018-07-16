package com.liferay;

import java.util.Arrays;
import java.util.List;

import com.liferay.shopping.ShoppingStore;

public class Main {

    public static void main(String[] args) {
        ShoppingStore shoppingStore = ShoppingStore.getInstance();

        List<String> filePaths = Arrays.asList("input-files/input1.txt", "input-files/input2.txt", "input-files/input3.txt");
        
        for (String filePath: filePaths) {
            shoppingStore.processOrderAndCreateReceipt(filePath);
        }
    }
}
