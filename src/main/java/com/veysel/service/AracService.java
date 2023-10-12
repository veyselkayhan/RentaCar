package com.veysel.service;

import com.veysel.repository.AracRepository;
import com.veysel.repository.entity.Arac;
import com.veysel.utility.MyFactoryService;

public class AracService  extends MyFactoryService<AracRepository,Arac,Long> {
    public AracService() {
        super(new AracRepository());
    }
}
