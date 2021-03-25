package com.with98labs.spring.boot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Value("${spring.profiles.active:}")
    private String activeProfiles;

    @GetMapping(value = "/profile", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getActiveProfiles() {
        return String.format("{\"profile\":\"%s\"}", activeProfiles);
    }

}
