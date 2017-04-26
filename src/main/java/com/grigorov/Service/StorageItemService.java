package com.grigorov.Service;

import com.grigorov.Entity.SparePart;
import com.grigorov.Entity.StorageItem;

import java.util.List;

public interface StorageItemService {
    StorageItem add(StorageItem item);
    void delete(StorageItem item);
    List<StorageItem> getAll();
    StorageItem getById(Long itemId);
}
