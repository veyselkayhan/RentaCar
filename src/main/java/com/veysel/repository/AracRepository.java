package com.veysel.repository;

import com.veysel.repository.entity.Arac;
import com.veysel.utility.MyFactoryRepository;

public class AracRepository extends MyFactoryRepository<Arac,Long> {
    public AracRepository() {
        super(new Arac());
    }
}
