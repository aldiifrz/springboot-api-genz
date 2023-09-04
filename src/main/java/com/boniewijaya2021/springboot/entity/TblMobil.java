package com.boniewijaya2021.springboot.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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

    @Column(name = "mobil_name")
    private String mobilName;

    @Column(name = "mobil_model")
    private String mobilModel;



}
