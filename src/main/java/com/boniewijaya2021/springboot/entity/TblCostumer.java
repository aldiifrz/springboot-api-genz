package com.boniewijaya2021.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Setter
    @Getter
    @Entity
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "tbl_costumer", schema = "sample")
    public class TblCostumer implements Serializable {
        @Id

        @Column(name = "costumer_name")
        private String costumerName;

        @Column(name = "costumer_age")
        private int costumerAge;

        @Column(name = "costumer_city")
        private String costumerCity;

        @Column(name = "costumer_type")
        private String costumerType;

        @Column(name = "costumer_item")
        private List<costumerItem> costumerItems;


    }
