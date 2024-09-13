package com.sourabh.Restful_web_services.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String HelloWorld(){
        return "Hello World";
    }

    @GetMapping("/hellobean/path-variable/{message}")
    public HelloWorldBean HelloBean( @PathVariable String message){
        return new HelloWorldBean(message);
    }
}
