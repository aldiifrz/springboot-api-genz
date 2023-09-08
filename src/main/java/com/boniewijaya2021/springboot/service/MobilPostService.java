package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.TblCostumer;
import com.boniewijaya2021.springboot.entity.TblMobil;
import com.boniewijaya2021.springboot.pojo.MobilPojo;
import com.boniewijaya2021.springboot.repository.CostumerRepository;
import com.boniewijaya2021.springboot.repository.MobilRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MobilPostService {
    @Autowired
    private MobilRepository mobilRepository;

    @Autowired
    private CostumerRepository costumerRepository;


    public ResponseEntity<MessageModel> addDataMobil(MobilPojo mobilPojo) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try{
            TblCostumer tblCostumer = new TblCostumer();
            tblCostumer.setCostumerName(mobilPojo.getCostumerName());
            tblCostumer.setCostumerAge(mobilPojo.getCostumerAge());
            tblCostumer.setCostumerCity(mobilPojo.getCostumerCity());
            tblCostumer.setCostumerType(mobilPojo.getCostumerType());
            TblCostumer save = costumerRepository.save(tblCostumer);

            for(MobilPojo.MobilType mobilType: mobilPojo.getSalesItem()) {
                TblMobil tblMobil = new TblMobil();
                tblMobil.setMobilName(mobilType.getMobilName());
                tblMobil.setMobilModel(String.join(",", mobilType.getMobilModel()));
                tblMobil.setIdCostumer(save.getIdCostumer());
                mobilRepository.save(tblMobil);
            }

            msg.setStatus(true);
            msg.setMessage("Sukses");
            msg.setData(mobilPojo);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
}
