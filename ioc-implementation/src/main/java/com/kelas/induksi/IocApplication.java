package com.kelas.induksi;

import com.kelas.induksi.model.Fruit;
import com.kelas.induksi.model.Jeruk;
import com.kelas.induksi.service.StoreService;
import com.kelas.induksi.service.impl.StoreServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {

//        SpringApplication.run(IocApplication.class, args);

        StoreService storeService = new StoreServiceImpl();

        Fruit jeruk = new Jeruk();

        System.out.println(jeruk.getName());
        System.out.println( storeService.addNewFruit(new Jeruk()));
    }

}
