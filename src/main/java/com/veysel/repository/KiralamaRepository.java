package com.veysel.repository;

import com.veysel.repository.entity.Arac;
import com.veysel.repository.entity.Kiralama;
import com.veysel.utility.MyFactoryRepository;

public class KiralamaRepository extends MyFactoryRepository<Kiralama,Long> {

    public KiralamaRepository() {
        super(new Kiralama());
    }
}
