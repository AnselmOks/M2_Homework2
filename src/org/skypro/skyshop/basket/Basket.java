package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class Basket {

    private Map<String, List<Product>> products;

    public Basket() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = products.remove(name);
        if (removedProducts == null) {
            return new ArrayList<>();
        }
        return removedProducts;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (List<Product> listOfProducts : products.values()) {
            for (Product product : listOfProducts) {
                if (product != null) {
                    totalPrice += product.getPrice();
                }
            }
        }
        return totalPrice;
    }

    private int getNumberOfSpecials() {
        int numberOfSpecials = 0;
        for (List<Product> listOfProducts : products.values()) {
            for (Product product : listOfProducts) {
                if (product != null && product.isSpecial()) {
                    numberOfSpecials++;
                }
            }
        }
        return numberOfSpecials;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        for (List<Product> listOfProducts : products.values()) {
            for (Product product : listOfProducts) {
                if (product != null) {
                    System.out.println(product);
                }
            }
        }
        System.out.println("Итого: " + this.getTotalPrice());
        System.out.println("Специальных товаров: " + this.getNumberOfSpecials());
    }

    public boolean isProductInBasket(String name) {
        return (products.containsKey(name));
    }

    public void clearBasket() {
        products.clear();
    }
}
