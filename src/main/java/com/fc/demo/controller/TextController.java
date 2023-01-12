package com.fc.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
public class TextController {
    @GetMapping("/sum")
    public Integer getSum(@RequestParam List<Integer> integers) {
        if (integers == null) {
            return 0;
        }
        System.out.println("Wysłana lista :" + integers);
        return integers.stream().mapToInt(Integer::intValue).sum();
    }


}
