package com.grigorov.DAO;

import com.grigorov.Entity.SparePart;
import com.grigorov.Entity.User;

import java.util.List;

public interface SparepartDAO {
    SparePart mergePart(SparePart part);
    void deletePart(SparePart part);
    List<SparePart> getAll();
    SparePart getById(Long partId);
}
