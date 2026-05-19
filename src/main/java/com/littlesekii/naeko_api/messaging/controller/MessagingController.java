package com.littlesekii.naeko_api.messaging.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.littlesekii.naeko_api.messaging.service.MessagingService;

@RestController
@RequestMapping("/api/messaging")
public class MessagingController {

    @Autowired
    MessagingService service;
    
    @PostMapping("/sendMessage")
    public ResponseEntity<Void> sendMessage(@RequestBody Map<String, String> res) {        
        service.send(res.get("message"));
        return ResponseEntity.ok().build();
    }
}
