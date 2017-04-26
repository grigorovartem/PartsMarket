package com.grigorov.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
public class StorageItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid")
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
        private SparePart part;

    @Column(name = "quantity")
    private int quantity;

    public StorageItem() {
    }

    public StorageItem(SparePart part, int quantity) {
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
