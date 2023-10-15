package com.veysel.repository.entity;


import com.veysel.enums.EMarka;
import com.veysel.enums.EModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_arac")
public class Arac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String marka;
    private String model;
    private Boolean durum;

    @Enumerated
    EMarka eMarka;

    @Enumerated
    EModel eModel;

    @Column(nullable = false,unique = true)
    String plaka;

    @OneToMany(mappedBy = "arac",cascade = CascadeType.ALL)
    List<Kiralama>kiralamaList;



}
