package com.grigorov.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class CommonDAO {

    //private EntityManagerFactory factory = Persistence.createEntityManagerFactory("spm");
    @Autowired
    protected EntityManager manager;

    public <T> T merge(T entity) {
        T entityDB = manager.merge(entity);
        return entityDB;
    }

    public <T> void delete(T entity) {
        manager.getTransaction().begin();
        try {
            manager.remove(entity);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            manager.getTransaction().rollback();
        }
        manager.clear();
    }

    public <T> List<T> getAll(Class<T> clazz) {
        CriteriaQuery<T> querry = manager.getCriteriaBuilder().createQuery(clazz);
        Root<T> root = querry.from(clazz);
        return manager.createQuery(querry.select(root)).getResultList();
    }

    public <T> T getById(Object id, Class<T> clazz) {
        return manager.find(clazz, id);
    }
}
