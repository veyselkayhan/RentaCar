package com.veysel.service;

import com.veysel.repository.KiralamaRepository;
import com.veysel.repository.KisiRepository;
import com.veysel.repository.entity.Kiralama;
import com.veysel.repository.entity.Kisi;
import com.veysel.utility.MyFactoryService;

public class KisiService extends MyFactoryService<KisiRepository, Kisi,Long> {
    public KisiService() {
        super(new KisiRepository());
    }
}
