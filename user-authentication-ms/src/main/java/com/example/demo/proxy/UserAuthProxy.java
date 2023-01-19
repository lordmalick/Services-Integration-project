package com.example.demo.proxy;

import com.example.demo.appuser.AppUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="authentication-service")
public interface UserAuthProxy {
    @GetMapping("/user-authentications/user/email/{email}")
    public AppUser getUser(
            @PathVariable String email);
}
