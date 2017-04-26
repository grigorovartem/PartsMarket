package com.grigorov.Service;

import com.grigorov.DAO.CommonDAO;
import com.grigorov.DAO.StorageItemDAOImpl;
import com.grigorov.Entity.StorageItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StorageItemServiceImpl implements StorageItemService {

    @Autowired
    private StorageItemDAOImpl storageItemDAO;

    @Transactional
    @Override
    public StorageItem add(StorageItem item) {
        return storageItemDAO.mergePart(item);
    }

    @Transactional
    @Override
    public void delete(StorageItem item) {
storageItemDAO.delete(item);
    }

    @Transactional
    @Override
    public List<StorageItem> getAll() {
        return storageItemDAO.getAll(StorageItem.class);
    }

    @Transactional
    @Override
    public StorageItem getById(Long itemId) {
        return storageItemDAO.getById(itemId, StorageItem.class);
    }
}
