package com.grigorov.DAO;

import com.grigorov.Entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl extends CommonDAO implements OrderDAO{
    @Override
    public Order mergeOrder(Order order) {
        return super.merge(order);
    }

    @Override
    public void deleteOrder(Order order) {
super.delete(order);
    }

    @Override
    public List<Order> getAll() {
        return super.getAll(Order.class);
    }

    @Override
    public Order getById(Long orderId) {
        return super.getById(orderId, Order.class);
    }
}
