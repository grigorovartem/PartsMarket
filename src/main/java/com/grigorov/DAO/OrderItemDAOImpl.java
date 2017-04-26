package com.grigorov.DAO;

import com.grigorov.Entity.OrderItem;
import com.grigorov.Entity.StorageItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemDAOImpl extends CommonDAO implements OrderItemDAO{

    @Override
    public OrderItem mergePart(OrderItem item) {
        return super.merge(item);
    }

    @Override
    public void deleteItem(OrderItem item) {
super.delete(item);
    }

    @Override
    public List<OrderItem> getAll() {
        return super.getAll(OrderItem.class);
    }

    @Override
    public OrderItem getById(Long itemId) {
        return super.getById(itemId, OrderItem.class);
    }
}
