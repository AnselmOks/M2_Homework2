package org.skypro.skyshop.product;

import org.skypro.skyshop.service.Searchable;

public abstract class Product implements Searchable {

    private final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product: неверное имя продукта");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchItem() {
        return getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getObjectName() {
        return getName();
    }
}
