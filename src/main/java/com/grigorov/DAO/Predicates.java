package com.grigorov.DAO;

import com.grigorov.Entity.SparePart;
import com.grigorov.Entity.StorageItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Predicates {

    @Autowired
    private EntityManager manager;

    private CriteriaBuilder builder;// = manager.getCriteriaBuilder();
    private CriteriaQuery<SparePart> query;// = builder.createQuery(SparePart.class);
    private Root<SparePart> parts;// = query.from(SparePart.class);
    private List<Predicate> predicates;// = new ArrayList<>();

//    public Predicates(){}

    public Predicates() {
//                this.builder = manager.getCriteriaBuilder();
//        this.query = builder.createQuery(SparePart.class);
//        this.parts = query.from(SparePart.class);
//        this.predicates = new ArrayList<>();
    }

    public Predicate pricePredicate(double fromPrice, double toPrice) {
        builder = manager.getCriteriaBuilder();
        query = builder.createQuery(SparePart.class);
        parts = query.from(SparePart.class);
        return builder.between(parts.get("price"), fromPrice, toPrice);
            }

    public Predicate namePredicate(String pattern) {
        builder = manager.getCriteriaBuilder();
        query = builder.createQuery(SparePart.class);
        parts = query.from(SparePart.class);
        return builder.like(parts.get("name"), pattern);
    }

    public List<StorageItem> filter(Predicate...predicates) {
        //Predicate[] predicatesArray = predicates.toArray(new Predicate[predicates.size()]);
        query.select(parts).where(builder.and(predicates));

        List<SparePart> spareParts = manager.createQuery(query).getResultList();
        CriteriaQuery<StorageItem> itemQuery = builder.createQuery(StorageItem.class);
        Root<StorageItem> items = itemQuery.from(StorageItem.class);

        List<StorageItem> filtered = new ArrayList<>();
        for (SparePart part : spareParts) {
            filtered.add(manager.createQuery(itemQuery.select(items)
                    .where(builder.equal(items.get("part"), part))).getSingleResult());
        }
        if (spareParts.size() == 0) {
            System.out.println("No products meets the conditions");
            return null;
        }
        return filtered;

    }
}
