package com.kelas.induksi.service;

import com.kelas.induksi.model.Fruit;

import java.util.List;

public interface StoreService {
    public Fruit addNewFruit(Fruit fruit);
    public List<Fruit> findAllFruits();
    public void sellAFruit();
}
