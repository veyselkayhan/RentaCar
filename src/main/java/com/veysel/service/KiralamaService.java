package com.veysel.service;

import com.veysel.repository.KiralamaRepository;
import com.veysel.repository.entity.Kiralama;
import com.veysel.utility.MyFactoryService;

public class KiralamaService extends MyFactoryService<KiralamaRepository, Kiralama,Long> {

    public KiralamaService() {
        super(new KiralamaRepository());
    }
}
