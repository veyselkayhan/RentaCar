package com.veysel.repository;

import com.veysel.repository.entity.Arac;
import com.veysel.repository.entity.Kisi;
import com.veysel.utility.MyFactoryRepository;

public class KisiRepository extends MyFactoryRepository<Kisi,Long> {
    public KisiRepository() {
        super(new Kisi());
    }
}
