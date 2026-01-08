package org.skypro.skyshop.service;

public interface Searchable {

    String getSearchItem();

    String getContentType();

    String getObjectName();

    default String getStringRepresentation() {
        return getObjectName() + " - " + getContentType();
    }

}
