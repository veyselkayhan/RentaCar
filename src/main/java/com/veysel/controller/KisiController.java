package com.veysel.controller;

import com.veysel.repository.entity.Kisi;
import com.veysel.service.KisiService;

import java.util.List;
import java.util.Optional;

public class KisiController {

    KisiService kisiService;

    public KisiController() {

        this.kisiService=new KisiService();
    }

    public Kisi save(Kisi kisi){
        return kisiService.save(kisi);
    }

    public Optional<Kisi>kisiBul(Long id){
       return kisiService.findById(id);
    }

    public List<Kisi>kisiList(String columnName ,String id){
        return kisiService.findByColumnNameAndValue(columnName,id);
    }

    public List<Kisi>findAll(){
        return kisiService.findAll();
    }
}
