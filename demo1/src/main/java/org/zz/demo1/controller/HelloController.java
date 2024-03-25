package org.zz.demo1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.zz.demo1.service.AopLogService;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    private final AopLogService aopLogService;

    public HelloController(AopLogService aopLogService) {
        this.aopLogService = aopLogService;
    }

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id") Integer id) {
        return aopLogService.test(id);
    }
}
