package com.grigorov.DAO;

import com.grigorov.Entity.SparePart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SparepartDAOImpl extends CommonDAO implements SparepartDAO{
    @Override
    public SparePart mergePart(SparePart part) {
        return super.merge(part);
    }

    @Override
    public void deletePart(SparePart part) {
super.delete(part);
    }

    @Override
    public List<SparePart> getAll() {
        return super.getAll(SparePart.class);
    }

    @Override
    public SparePart getById(Long partId) {
        return super.getById(partId, SparePart.class);
    }
}
