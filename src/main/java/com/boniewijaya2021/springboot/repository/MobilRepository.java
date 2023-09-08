package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.TblMobil;
import com.boniewijaya2021.springboot.entity.TblCostumer;
import com.boniewijaya2021.springboot.pojo.MobilPojo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MobilRepository extends JpaRepository<TblMobil, UUID> {

    List<TblMobil> getByIdCostumer (UUID idCostumer);


}
