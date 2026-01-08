package org.skypro.skyshop.article;

import org.skypro.skyshop.service.Searchable;

public class Article implements Searchable {

    private final String header;
    private final String text;

    public Article(String header, String text) {
        this.header = header;
        this.text = text;
    }

    public String getHeader() {
        return header;
    }

    @Override
    public String toString() {
        return header + System.lineSeparator() + text;
    }

    @Override
    public String getSearchItem() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getObjectName() {
        return getHeader();
    }
}
