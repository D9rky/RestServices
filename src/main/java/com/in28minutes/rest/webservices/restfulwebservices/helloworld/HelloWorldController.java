package com.in28minutes.rest.webservices.restfulwebservices.helloworld;


import com.in28minutes.rest.webservices.restfulwebservices.helloworld.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String HelloWorld(){
        return "Hello world";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean HelloWorldBean(){
        return new HelloWorldBean("Hello world");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean HelloWorldVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(){
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }

}
