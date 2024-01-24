package org.youjhin.gbspringhw3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private DataProcessingService dataProcessingService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        return new ResponseEntity<>(registrationService.registrationUser(name, age, email), HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> getAllUsersFromDB(){
        return new ResponseEntity<>(dataProcessingService.getAllUsersFromBase(),HttpStatus.OK);
    }

}
