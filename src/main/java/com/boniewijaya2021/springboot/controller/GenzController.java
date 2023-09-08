package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.pojo.MobilPojo;
import com.boniewijaya2021.springboot.service.MobilGetService;
import com.boniewijaya2021.springboot.service.MobilPostService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sample")
public class GenzController {

    @Autowired
    private MobilGetService mobilGetService;

    @Autowired
    private MobilPostService mobilPostService;

    @GetMapping("/get/mobil")
    public ResponseEntity getDataMobil(@RequestParam UUID idCostumer) {
        ResponseEntity responseEntity = mobilGetService.getDataMobil(idCostumer);
        return responseEntity;
    }

    @PostMapping("/post/mobil")
    private ResponseEntity<MessageModel> addDataMobil(@RequestParam MobilPojo mobilPojo) {
        ResponseEntity responseEntity = mobilPostService.addDataMobil(mobilPojo);
        return responseEntity;
    }

}
