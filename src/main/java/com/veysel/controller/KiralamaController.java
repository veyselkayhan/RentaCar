package com.veysel.controller;

import com.veysel.repository.KiralamaRepository;
import com.veysel.repository.entity.Kiralama;
import com.veysel.service.KiralamaService;

import java.util.List;

public class KiralamaController {

    KiralamaService kiralamaService;

    public KiralamaController() {
        this.kiralamaService=new KiralamaService();
    }

    public Kiralama kiralamaYap(Kiralama kiralama){
        return kiralamaService.save(kiralama);
    }

    public List<Kiralama>kiraladıgımAraclar(){
        return kiralamaService.findAll();
    }


}
