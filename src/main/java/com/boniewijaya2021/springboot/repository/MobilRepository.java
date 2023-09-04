package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.TblMobil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobilRepository extends JpaRepository<TblMobil, Long> {

}
