package com.intro.microservices.defaultadmincredentialsservice.controller;

import com.intro.microservices.defaultadmincredentialsservice.config.Configuration;
import com.intro.microservices.defaultadmincredentialsservice.pojo.AdminCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminCredentialController {
    @Autowired
    private Configuration configuration;
    @GetMapping("/admincredential")
    public AdminCredential getAdminCredential()
    {
        return new AdminCredential(configuration.getLogin(),configuration.getPassword());
    }

}
