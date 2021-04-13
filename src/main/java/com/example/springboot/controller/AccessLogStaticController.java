package com.example.springboot.controller;

import com.example.springboot.dal.AccessLogStaticRepository;
import com.example.springboot.model.AccessLogStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accessLogStatic")
public class AccessLogStaticController {
    @Autowired
    private final AccessLogStaticRepository accessLogStaticRepository;

    public AccessLogStaticController(AccessLogStaticRepository accessLogStaticRepository) {
        this.accessLogStaticRepository = accessLogStaticRepository;
    }

    @GetMapping("")
    public List<AccessLogStatic> getAllUsers() {
        return accessLogStaticRepository.findAll();
    }

    @GetMapping("/acc")
    public AccessLogStatic addNewUser(@RequestBody AccessLogStatic user) {
        return accessLogStaticRepository.save(user);
    }
}
