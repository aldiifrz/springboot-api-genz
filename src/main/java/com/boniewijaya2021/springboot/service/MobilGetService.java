package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.TblCostumer;
import com.boniewijaya2021.springboot.entity.TblMobil;
import com.boniewijaya2021.springboot.pojo.CostumerPojo;
import com.boniewijaya2021.springboot.pojo.MobilPojo;
import com.boniewijaya2021.springboot.repository.CostumerRepository;
import com.boniewijaya2021.springboot.repository.MobilRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MobilGetService {
    @Autowired
    private CostumerRepository costumerRepository;

    @Autowired
    private MobilRepository mobilRepository;

    public ResponseEntity<MessageModel> getDataMobil(UUID idMobil) {
        Map<String, Object> result = new HashMap<>();

        MessageModel msg = new MessageModel();
        try {
            TblCostumer data = costumerRepository.findById(idMobil).get();
            MobilPojo mobilPojo = new MobilPojo();
            mobilPojo.setCostumerName(data.getCostumerName());
            mobilPojo.setCostumerAge(data.getCostumerAge());
            mobilPojo.setCostumerCity(data.getCostumerCity());
            mobilPojo.setCostumerType(data.getCostumerType());

            List<TblMobil> byIdCostumer = mobilRepository.getByIdCostumer(data.getIdCostumer());
            List<MobilPojo.MobilType> newList = new ArrayList<>();
            for(TblMobil tblMobil : byIdCostumer) {
                MobilPojo.MobilType mobilType = new MobilPojo.MobilType();
                mobilType.setMobilName(tblMobil.getMobilName());
                mobilType.setMobilModel(Arrays.asList(tblMobil.getMobilModel().split(",")));
                newList.add(mobilType);
            }
            mobilPojo.setSalesItem(newList);

            if(data.getIdCostumer()==null) {
                msg.setStatus(true);
                msg.setMessage("data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            } else {
                msg.setStatus(true);
                msg.setMessage("Sukses");
                msg.setData(mobilPojo);
                return ResponseEntity.ok().body(msg);
            }
        } catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);
        }
    }
}

