package com.liferay.shopping;

import com.liferay.products.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoreShelfTest {

    @Test
    public void getBookProductTest() throws ProductNotAvailableException {
        StoreShelf storeShelf = new StoreShelf();
        String name = "book";
        double value = 10.0;
        int quantity = 1;
        boolean imported = false;
        Product expectedProduct = new BookProduct(name, value, quantity, imported);

        Product product = storeShelf.getProduct(name, value, quantity, imported);

        assertTrue(product instanceof BookProduct);
        assertEquals(expectedProduct, product);
    }

    @Test
    public void getFoodProductTest() throws ProductNotAvailableException {
        StoreShelf storeShelf = new StoreShelf();
        String name = "chocolate bar";
        double value = 5.0;
        int quantity = 2;
        boolean imported = true;
        Product expectedProduct = new FoodProduct(name, value, quantity, imported);

        Product product = storeShelf.getProduct(name, value, quantity, imported);

        assertTrue(product instanceof FoodProduct);
        assertEquals(expectedProduct, product);
    }

    @Test
    public void getMedicalProductTest() throws ProductNotAvailableException {
        StoreShelf storeShelf = new StoreShelf();
        String name = "packet of headache pills";
        double value = 9.9;
        int quantity = 6;
        boolean imported = false;
        Product expectedProduct = new MedicalProduct(name, value, quantity, imported);

        Product product = storeShelf.getProduct(name, value, quantity, imported);

        assertTrue(product instanceof MedicalProduct);
        assertEquals(expectedProduct, product);
    }

    @Test
    public void getMiscellaneousProductTest() throws ProductNotAvailableException {
        StoreShelf storeShelf = new StoreShelf();
        String name = "bottle of perfume";
        double value = 1.99;
        int quantity = 4;
        boolean imported = true;
        Product expectedProduct = new MiscellaneousProduct(name, value, quantity, imported);

        Product product = storeShelf.getProduct(name, value, quantity, imported);

        assertTrue(product instanceof MiscellaneousProduct);
        assertEquals(expectedProduct, product);
    }

    @Test
    public void getNotAvailableProductTest() {
        StoreShelf storeShelf = new StoreShelf();
        String name = "nothing";
        double value = 2.0;
        int quantity = 1;
        boolean imported = false;

        ProductNotAvailableException exception = Assertions.assertThrows(ProductNotAvailableException.class, () -> {
            storeShelf.getProduct(name, value, quantity, imported);
        });

        assertEquals("Product 'nothing' is not available.", exception.getMessage());
    }
}
