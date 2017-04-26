package com.grigorov.Sorting;

import com.grigorov.Entity.StorageItem;
import org.springframework.stereotype.Component;

import java.util.*;

public class StorageComparators {

    private Map<String, Comparator<StorageItem>> comparators;

    public StorageComparators() {
        this.comparators = new HashMap<>();
        comparators.put("ascending", byPrice());
        comparators.put("name", byName());
    }

    public Comparator<StorageItem> byPrice() {
        return new Comparator<StorageItem>() {
            @Override
            public int compare(StorageItem part1, StorageItem part2) {
                if (part1.getPart().getPrice().compareTo(part2.getPart().getPrice()) == 0) {
                    return 1;
                }
                return part1.getPart().getPrice().compareTo(part2.getPart().getPrice());
            }
        };
    }

    public Comparator<StorageItem> byName() {
        return new Comparator<StorageItem>() {
            @Override
            public int compare(StorageItem part1, StorageItem part2) {
                return part1.getPart().getName().compareTo(part2.getPart().getName());
            }
        };
    }

    public Comparator<StorageItem> getComparator(String condition){
        return comparators.get(condition);
    }
}
