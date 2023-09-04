package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.TblProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<TblProduct, UUID> {

}
