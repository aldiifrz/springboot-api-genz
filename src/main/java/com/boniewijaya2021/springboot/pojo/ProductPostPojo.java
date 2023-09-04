package com.boniewijaya2021.springboot.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ProductPostPojo {
    private String namaBarang;
    private String tipeBarang;
    private String asalBarang;
    private LocalDateTime tanggalProduksi;
    private Integer biayaProduksi;
}
