package com.grigorov.Sorting;

import com.grigorov.Entity.StorageItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class Sorter {

    public List<StorageItem> sort(String condition, List<StorageItem> items) {
        StorageComparators comparators = new StorageComparators();
        Comparator comparator = comparators.getComparator(condition);
        Collections.sort(items, comparator);
        return items;
    }
}
