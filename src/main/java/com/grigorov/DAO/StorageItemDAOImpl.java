package com.grigorov.DAO;

import com.grigorov.Entity.StorageItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StorageItemDAOImpl extends CommonDAO implements StorageItemDAO {
    @Override
    public StorageItem mergePart(StorageItem item) {
        return super.merge(item);
    }

    @Override
    public void deleteItem(StorageItem item) {
super.delete(item);
    }

    @Override
    public List<StorageItem> getAll() {
        return super.getAll(StorageItem.class);
    }

    @Override
    public StorageItem getById(Long itemId) {
        return super.getById(itemId, StorageItem.class);
    }
}
