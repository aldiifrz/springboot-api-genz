package com.boniewijaya2021.springboot.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_mobil", schema = "sample")
public class TblMobil implements Serializable {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_mobil")
    private UUID idMobil;

    @Column(name = "mobil_name")
    private String mobilName;

    @Column(name = "mobil_model")
    private String mobilModel;

    @Column(name = "id_costumer")
    private UUID idCostumer;




}
