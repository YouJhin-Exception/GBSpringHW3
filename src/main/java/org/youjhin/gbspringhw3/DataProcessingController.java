package org.youjhin.gbspringhw3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class DataProcessingController {


    @Autowired
    private final DataProcessingService dataProcessingService;


    public DataProcessingController(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }


    @GetMapping(value = "/hello")
    public ResponseEntity<String> helloResponse() {
        String response = dataProcessingService.getGreeting();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/sort")
    public ResponseEntity<List<User>> sortUsers(@RequestBody List<User> users) {

        return new ResponseEntity<>(dataProcessingService.sortUserByAge(users), HttpStatus.OK);

    }


    @GetMapping(value = "/filter/{age}")
    public ResponseEntity<List<User>> filterUsersByAge(@PathVariable("age") Integer age, @RequestBody List<User> users) {
        return new ResponseEntity<>(dataProcessingService.filterUserByAge(users, age), HttpStatus.OK);
    }

    @PostMapping(value = "/average")
    public  ResponseEntity<Double> averageAge(@RequestBody List<User> users){
        return new ResponseEntity<>(dataProcessingService.calculateAverageAge(users), HttpStatus.OK);
    }

}
