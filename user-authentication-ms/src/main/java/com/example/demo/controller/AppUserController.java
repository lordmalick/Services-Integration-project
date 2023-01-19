package com.example.demo.controller;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppUserController {
       @Autowired
        private  AppUserService appUserService;

 @GetMapping("/user-authentications/user/email/{email}")
    public AppUser getUser(@PathVariable String email)
 {
     return appUserService.getAppUser(email);
 }

}
