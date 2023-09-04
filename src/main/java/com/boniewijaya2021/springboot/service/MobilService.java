package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.TblCostumer;
import com.boniewijaya2021.springboot.entity.TblMobil;
import com.boniewijaya2021.springboot.entity.TblProduct;
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
public class MobilService {
    @Autowired
    private MobilRepository mobilRepository;


    public ResponseEntity<MessageModel> addDataMobil(TblMobil tblMobil) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            mobilRepository.save(tblMobil);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", tblMobil);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
    public ResponseEntity getDataMobil() {
        List<TblMobil> tblMobil = (List<TblMobil>) mobilRepository.findAll();
        if (!tblMobil.isEmpty()) {
            return ResponseEntity.ok(tblMobil);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");
        }
    }
}
