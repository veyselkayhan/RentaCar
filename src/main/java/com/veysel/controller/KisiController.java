package com.veysel.controller;

import com.veysel.repository.entity.Kisi;
import com.veysel.service.KisiService;

public class KisiController {

    KisiService kisiService;

    public KisiController() {

        this.kisiService=new KisiService();
    }

    public Kisi save(Kisi kisi){
        return kisiService.save(kisi);
    }
}
