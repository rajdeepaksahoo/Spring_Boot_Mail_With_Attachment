package com.springboot.mail.email.controller;

import com.springboot.mail.email.service.SpringEmailService;
import com.springboot.mail.entity.MyEntity;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {
    @Autowired
    SpringEmailService service;
    @PostMapping("/send")
    public ResponseEntity<Map<String, HttpStatus>> send(@RequestBody MyEntity myEntity) throws MessagingException, IOException {
        Map<String,HttpStatus> map = new HashMap<>();
        map.put("Created",HttpStatus.OK);

        service.sendMail(myEntity);

        return ResponseEntity.ok(map);
    }
}
