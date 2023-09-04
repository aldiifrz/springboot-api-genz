package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.TblPerson;
import com.boniewijaya2021.springboot.entity.TblUsers;
import com.boniewijaya2021.springboot.pojo.PersonPostPojo;
import com.boniewijaya2021.springboot.pojo.UsersPostPojo;
import com.boniewijaya2021.springboot.repository.PersonRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public ResponseEntity<MessageModel> addPersonData(PersonPostPojo personPostPojo)
    {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
        TblPerson tblPerson = new TblPerson();
        tblPerson.setPersonName(personPostPojo.getPersonName());;
        tblPerson.setPersonEmail(personPostPojo.getPersonEmail());
        personRepository.save(tblPerson);
        msg.setStatus(true);
        msg.setMessage("Success");
        result.put("data", tblPerson);
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
