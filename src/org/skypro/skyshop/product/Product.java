package org.skypro.skyshop.product;

import org.skypro.skyshop.service.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Searchable product)) return false;
        return Objects.equals(name, product.getObjectName());
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
