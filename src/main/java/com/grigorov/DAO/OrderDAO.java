package com.grigorov.DAO;

import com.grigorov.Entity.Order;
import com.grigorov.Entity.StorageItem;

import java.util.List;

public interface OrderDAO {
    Order mergeOrder(Order order);
    void deleteOrder(Order order);
    List<Order> getAll();
    Order getById(Long orderId);
}
