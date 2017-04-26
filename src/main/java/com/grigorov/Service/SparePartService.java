package com.grigorov.Service;

import com.grigorov.Entity.SparePart;

import java.util.List;

public interface SparePartService {
    SparePart add(SparePart part);
    void delete(SparePart part);
    List<SparePart> getAll();
    SparePart getById(Long partId);
}
