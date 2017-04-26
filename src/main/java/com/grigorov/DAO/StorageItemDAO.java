package com.grigorov.DAO;

import com.grigorov.Entity.SparePart;
import com.grigorov.Entity.StorageItem;

import java.util.List;

public interface StorageItemDAO {
    StorageItem mergePart(StorageItem item);
    void deleteItem(StorageItem item);
    List<StorageItem> getAll();
    StorageItem getById(Long itemId);
}
