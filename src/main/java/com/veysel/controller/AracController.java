package com.veysel.controller;

import com.veysel.repository.entity.Arac;
import com.veysel.service.AracService;

import java.util.Optional;

public class AracController {

    AracService aracService;

    public AracController() {
        this.aracService=new AracService();
    }

    public Arac save(Arac arac){
        new AracService().save(arac);
        return arac;
    }

    public Optional<Arac>findById(Long id){
        return aracService.findById(id);
    }

}
