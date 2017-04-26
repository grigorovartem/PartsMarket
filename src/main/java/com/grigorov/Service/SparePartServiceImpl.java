package com.grigorov.Service;

import com.grigorov.DAO.SparepartDAOImpl;
import com.grigorov.Entity.SparePart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SparePartServiceImpl implements SparePartService {

    @Autowired
    private SparepartDAOImpl sparepartDAO;

    @Transactional
    @Override
    public SparePart add(SparePart part) {
        return sparepartDAO.mergePart(part);
    }

    @Transactional
    @Override
    public void delete(SparePart part) {
sparepartDAO.delete(part);
    }

    @Transactional
    @Override
    public List<SparePart> getAll() {
        return sparepartDAO.getAll(SparePart.class);
    }

    @Transactional
    @Override
    public SparePart getById(Long partId) {
        return sparepartDAO.getById(partId, SparePart.class);
    }
}
