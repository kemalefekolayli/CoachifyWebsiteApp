package com.mycompany.coachifywebsite.Controller;


import io.coachify.entity.model.Coach;
import io.coachify.entity.repo.CoachRepository;
import io.coachify.entity.repo.UserRepository;
import io.coachify.security.service.AuthManager;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class RegisterController {


    @Autowired
    private AuthManager authManager;

    @PostMapping("/public/deneme")
    private ResponseEntity<String> denemeFonksiyon(@RequestBody String asd){
        System.out.println("burdayım");
        if(Objects.equals(asd, "123")){
            return ResponseEntity.ok("değer okey");

        }
        else{
            return ResponseEntity.ok("değer okey değil");
        }
    }
    @PostMapping("/public/register/coach")
    private ResponseEntity<String> registerCoach(@RequestBody Coach coachToBeRegistered ){
        String registerToken = authManager.registerCoach(coachToBeRegistered);
        if(registerToken == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(registerToken);
    }

    @PostMapping("/public/login/coach")
    private ResponseEntity<String> loginCoach(@RequestBody String username, @RequestBody String password){
        String loginToken = authManager.loginCoach(username, password);
        if(loginToken == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(loginToken);
    }


}
