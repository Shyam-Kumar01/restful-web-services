package com.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {
    
    @GetMapping(path = "/hello-world")
    public String Helloworld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloworldbean(){
        return new HelloWorldBean("Hello World Bean");
    }
}
