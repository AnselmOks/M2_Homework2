package org.skypro.skyshop.article;

import org.skypro.skyshop.service.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Searchable article)) return false;
        return Objects.equals(header, article.getObjectName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(header);
    }

}
