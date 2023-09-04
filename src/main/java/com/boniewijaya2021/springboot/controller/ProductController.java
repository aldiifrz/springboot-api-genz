package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.pojo.ProductPojo;
import com.boniewijaya2021.springboot.service.ProductPostService;
import com.boniewijaya2021.springboot.service.ProductService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductPostService productPostService;

    @GetMapping("/get/dataBarangClass")
    public ResponseEntity getBarangClass(@RequestParam(value = "namaBarang", required = false) String namaBarang,
                                         @RequestParam(value = "tipeBarang", required = false) String tipeBarang) {
        return productService.getBarangClass(namaBarang, tipeBarang);
    }

    @PostMapping("/post/dataBarangClass")
    private ResponseEntity<MessageModel> addBarangClass(@RequestBody ProductPojo productPojo) {
        ResponseEntity responseEntity = productPostService.addBarangClass(productPojo);
        return responseEntity;
    }

    @PutMapping("/put/dataBarangClass")
    public ResponseEntity<MessageModel> updateBarang(@RequestBody ProductPojo productPojo) {
        ResponseEntity responseEntity = productPostService.updateBarangClass(productPojo);
        return responseEntity;
    }


    @DeleteMapping("/delete/dataBarangClass/{idProduk}")
    public ResponseEntity removeBarangClass(@PathVariable("idProduksi") UUID idProduk) {
        ResponseEntity responseEntity = productPostService.deleteBarangClass(idProduk);
        return responseEntity;
    }



}
