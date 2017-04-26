package com.grigorov.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinColumn(name = "part_id")
        private List<OrderItem> spareParts;

    public void addPart(OrderItem part){
        spareParts.add(part);
    }
    public Order() {
    }

    public Order(User user) {
        this.user = user;
        this.spareParts = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getSpareParts() {
        return spareParts;
    }
}
