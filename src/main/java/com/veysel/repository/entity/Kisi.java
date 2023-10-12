package com.veysel.repository.entity;

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
@Table(name = "tbl_kisi")
public class Kisi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;


    private String name;

    private String username;

    private String password;

    @OneToMany(mappedBy = "kisi",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<Kiralama> kiralamaList;

}
