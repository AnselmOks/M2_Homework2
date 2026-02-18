package org.skypro.skyshop.service;

import java.util.Comparator;

public class CustomSearchComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        int compareLength = Integer.compare(o1.getObjectName().length(), o2.getObjectName().length());
        if (compareLength == 0) {
            return o1.getObjectName().compareTo(o2.getObjectName());
        } else {
            return compareLength;
        }
    }
}
