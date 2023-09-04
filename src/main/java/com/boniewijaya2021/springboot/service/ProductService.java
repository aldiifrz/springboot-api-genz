package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.TblProduct;
import com.boniewijaya2021.springboot.pojo.ProductPojo;
import com.boniewijaya2021.springboot.repository.ProductRepository;
import com.boniewijaya2021.springboot.repository.ProductRepositoryClass;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductRepositoryClass productRepositoryClass;

    public ResponseEntity getBarangClass(String namaBarang, String tipeBarang) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            List<ProductPojo> data = productRepositoryClass.getDataDinamic(namaBarang, tipeBarang);
            if(data.isEmpty()) {
                msg.setStatus(true);
                msg.setMessage("data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            } else {
                msg.setStatus(true);
                msg.setMessage("Success");
                result.put("data", data);
                msg.setData(result);
                return ResponseEntity.ok().body(msg);
            }
        } catch (Exception e) {
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);
        }
    }

    public ResponseEntity getDataBarang() {
        List<TblProduct> tblProduct = (List<TblProduct>) productRepository.findAll();
        if (!tblProduct.isEmpty()) {
            return ResponseEntity.ok(tblProduct);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");
        }
    }
    public  ResponseEntity<MessageModel> addDataBarang(TblProduct tblProduct) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            productRepository.save(tblProduct);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", tblProduct);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }

    public ResponseEntity<MessageModel> removeDataBarang(UUID idProduk) {
        MessageModel msg = new MessageModel();
        try {
            productRepository.deleteById(idProduk);
            msg.setStatus(true);
            msg.setMessage("Data successfully removed");
            return ResponseEntity.ok().body(msg);
        } catch (Exception e) {
            msg.setStatus(false);
            msg.setMessage("Data not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
}
