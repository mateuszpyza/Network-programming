package com.fc.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
public class TextController {
    @GetMapping("/echo")
    public String getEcho(@RequestParam String text) {
        if (text == null) {
            return null;
        }
        return text.toUpperCase();
    }


}
