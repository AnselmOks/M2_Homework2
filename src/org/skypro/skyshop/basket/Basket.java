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

    public List<Product> deleteProduct(String name) {
        List<Product> deletedProducts = new LinkedList<>();
        if (!products.containsKey(name)) {
            return deletedProducts;
        }
        List<Product> listOfProducts = products.get(name);
        deletedProducts.addAll(listOfProducts);
        products.remove(name);
        return deletedProducts;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (List<Product> listOfProducts : products.values()) {
            for (Product product : listOfProducts) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    private int getNumberOfSpecials() {
        int numberOfSpecials = 0;
        for (List<Product> listOfProducts : products.values()) {
            for (Product product : listOfProducts) {
                if (product.isSpecial()) {
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
                if (product.isSpecial()) {
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
