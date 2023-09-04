package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.TblCostumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<TblCostumer, Long> {


}
