package com.kelas.induksi.service.impl;

import com.kelas.induksi.model.Fruit;
import com.kelas.induksi.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class StoreServiceImpl implements StoreService {

    @Autowired
    Fruit fruit;

    ArrayList<Fruit> fruits = new ArrayList<>();

    @Override
    public Fruit addNewFruit(Fruit fruit) {
        this.fruit = fruit;
        this.fruits.add(fruit);
        return this.fruit;
    }

    @Override
    public List<Fruit> findAllFruits() {
        return this.fruits;
    }

    @Override
    public void sellAFruit() {

    }
}
