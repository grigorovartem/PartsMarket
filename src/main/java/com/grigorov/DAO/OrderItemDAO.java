package com.grigorov.DAO;

import com.grigorov.Entity.OrderItem;
import com.grigorov.Entity.StorageItem;

import java.util.List;

public interface OrderItemDAO {
    OrderItem mergePart(OrderItem item);
    void deleteItem(OrderItem item);
    List<OrderItem> getAll();
    OrderItem getById(Long itemId);
}
