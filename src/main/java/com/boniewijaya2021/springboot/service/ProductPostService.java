package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.pojo.ProductPojo;
import com.boniewijaya2021.springboot.repository.ProductRepository;
import com.boniewijaya2021.springboot.repository.ProductRepositoryClass;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class ProductPostService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductRepositoryClass productRepositoryClass;

    public ResponseEntity<MessageModel> addBarangClass(ProductPojo productPojo) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            if(productPojo.getTanggalProduksi() == null) {
                productPojo.setTanggalProduksi(LocalDateTime.now());
            }
            productRepositoryClass.updateDataBarang(productPojo);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", productPojo);
            msg.setData(result);
            return  ResponseEntity.status(HttpStatus.OK).body(msg);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }

    public ResponseEntity<MessageModel> updateBarangClass(ProductPojo productsPojo) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            if (productsPojo.getTanggalProduksi() == null) {
                productsPojo.setTanggalProduksi(LocalDateTime.now());
            }
            productRepositoryClass.updateDataBarang(productsPojo);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", productsPojo);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }

    }
    public ResponseEntity deleteBarangClass(UUID idProduk) {
        MessageModel msg = new MessageModel();
    try {
        productRepositoryClass.deleteDataBarang(idProduk);
        msg.setStatus(true);
        msg.setMessage("Data Deleted");
        return ResponseEntity.ok().body(msg);
    } catch (Exception e) {
        e.printStackTrace();
        msg.setStatus(false);
        msg.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }
    }
}
