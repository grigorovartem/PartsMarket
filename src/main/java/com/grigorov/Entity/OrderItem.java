package com.grigorov.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_products")
public class OrderItem {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long id;

        @OneToOne(fetch = FetchType.EAGER)
        private SparePart part;

        @Column(name = "quantity")
        private int quantity;

        @ManyToMany(mappedBy = "spareParts", cascade = CascadeType.ALL)
        private List<Order> orders;

        public OrderItem() {
        }

        public OrderItem(SparePart part, int quantity) {
            this.part = part;
            this.quantity = quantity;
        }

        public SparePart getPart() {
            return part;
        }

        public void setPart(SparePart part) {
            this.part = part;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

