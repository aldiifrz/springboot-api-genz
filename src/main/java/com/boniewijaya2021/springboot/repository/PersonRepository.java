package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.TblPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<TblPerson, Long> {
//    @Query(value = "SELECT cast (id_penjualan as varchar) id_penjualan, harga, nama_barang, sales_name\n" +
//            "FROM sample.tbl_penjualan where id_penjualan =:idSales", nativeQuery = true)
}
