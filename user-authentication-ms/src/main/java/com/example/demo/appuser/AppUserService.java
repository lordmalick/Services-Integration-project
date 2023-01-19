package com.example.demo.appuser;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";
    @Autowired
    private  AppUserRepository appUserRepository;
    public AppUser getAppUser(String email)
    {
        return appUserRepository.findByEmail(email)
               .orElseThrow(() ->
            new IllegalArgumentException(
                    String.format(USER_NOT_FOUND_MSG, email)));
    }


}
