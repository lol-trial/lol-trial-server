package org.lol.loltrial.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PostMapping("/tokentest")
    public String test() {
        return "test";
    }

    @GetMapping("/example/test")
    public String dd(@RequestParam("token") String token) {
        return token;
    }
}
