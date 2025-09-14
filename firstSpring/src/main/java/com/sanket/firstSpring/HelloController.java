package com.sanket.firstSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // This annotation indicates that this is a combination a ResponseBody & controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("/hello")
    public String postMethodName(@RequestBody String name) {

        return "Hello " + name + "!";
    }

}
