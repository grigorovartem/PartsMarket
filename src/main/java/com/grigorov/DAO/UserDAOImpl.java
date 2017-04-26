package com.grigorov.DAO;


import com.grigorov.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAOImpl extends CommonDAO implements UserDAO {

    @Override
    public User mergeUser(User user) {
        return super.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        super.delete(user);
    }

    @Override
    public List<User> getAll() {
        return super.getAll(User.class);
    }

    @Override
    public User getById(Long userId) {
        return super.getById(userId, User.class);
    }

    @Override
    public User getByName(String username) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<User> exchangerQuery = builder.createQuery(User.class);
        Root<User> root = exchangerQuery.from(User.class);
        exchangerQuery.select(root)
                .where(builder.equal(root.get("login"), username));
        return manager.createQuery(exchangerQuery).getSingleResult();
    }
}
