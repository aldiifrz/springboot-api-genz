package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.TblCostumer;
import com.boniewijaya2021.springboot.entity.TblUsers;
import com.boniewijaya2021.springboot.pojo.CostumerPojo;
import com.boniewijaya2021.springboot.pojo.UsersPostPojo;
import com.boniewijaya2021.springboot.repository.CostumerRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepository costumerRepository;
    public ResponseEntity<MessageModel> addDataCostumer(CostumerPojo costumerPojo)
    {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try{
            TblCostumer tblCostumer = new TblCostumer();
            tblCostumer.setCostumerName(costumerPojo.getCostumerName());
            tblCostumer.setCostumerCity(costumerPojo.getCostumerCity());
            tblCostumer.setCostumerAge(costumerPojo.getCostumerAge());
            tblCostumer.setCostumerType(costumerPojo.getCostumerType());
            costumerRepository.save(tblCostumer);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", tblCostumer);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
}
