package com.grigorov.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "spareparts")
public class SparePart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    @Enumerated(EnumType.STRING)
    private Brand brand;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "part")
    @JoinColumn(name = "part_id")
    private StorageItem storageItem;

//    @ManyToMany(mappedBy = "spareParts", cascade = CascadeType.ALL)
//        private List<Order> orders;

    public SparePart() {
    }

    public SparePart(String name, Brand brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = new BigDecimal(price);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SparePart part = (SparePart) o;

        if (getId() != part.getId()) return false;
        if (!getName().equals(part.getName())) return false;
        if (!getPrice().equals(part.getPrice())) return false;
        return getBrand() == part.getBrand();

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getBrand().hashCode();
        result = 31 * result + (int) (getId() ^ (getId() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "SparePart{" +
                "brand=" + brand +
                ", name=" + name +
                ", price=" + price +
                '}';
    }
}
