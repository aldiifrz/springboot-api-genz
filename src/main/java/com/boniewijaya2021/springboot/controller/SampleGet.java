package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.entity.TblSales;
import com.boniewijaya2021.springboot.entity.TblUsers;
import com.boniewijaya2021.springboot.pojo.UsersPostPojo;
import com.boniewijaya2021.springboot.service.PersonService;
import com.boniewijaya2021.springboot.service.SalesPostService;
import com.boniewijaya2021.springboot.service.SalesService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sample")
public class SampleGet {

    @Autowired
    private SalesService salesService;

    @Autowired
    private SalesPostService salesPostService;

//    @Autowired
//    private PersonService personService;

    //menambahkan person description



    @GetMapping("/get/dataPenjualan")
    public ResponseEntity getDataPenjualan(@RequestParam UUID idSales ){
        ResponseEntity responseEntity = salesService.getDataPenjualan(idSales);
        return responseEntity;

    }
    @GetMapping("/get/dataPenjualanClass")
    public ResponseEntity getDataPenjualanDinamic( String namaSales, String namaBarang){
        ResponseEntity responseEntity = salesService.getPenjualanClassrepo(namaSales, namaBarang);
        return responseEntity;
    }
//    @GetMapping("/get/dataPerson")
//    public ResponseEntity getDataPerson( String namaPerson, int personAge ) {
//        ResponseEntity responseEntity = personService.get
//    }

    @PostMapping("/post/sales")
    private ResponseEntity<MessageModel> addSales(@RequestBody TblSales tblSales) {
        ResponseEntity responseEntity = salesPostService.addDataPenjualan(tblSales);
        return responseEntity;
    }

    @PostMapping("/post/users")
    private ResponseEntity<MessageModel> addUsers(@RequestBody UsersPostPojo usersPostPojo) {
        ResponseEntity responseEntity = salesPostService.addDataUsers(usersPostPojo);
        return responseEntity;
    }


}
