package com.kelas.induksi.service.impl;

import com.kelas.induksi.model.Fruit;
import com.kelas.induksi.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;

public class FruitServiceImpl implements FruitService {
   @Autowired
    Fruit fruit;

    @Override
    public String getName() {
        return fruit.getName();
    }

    @Override
    public float getTotalPrice() {
//        return fruit.getPrice();
        return (float) 0.0;
    }
}
