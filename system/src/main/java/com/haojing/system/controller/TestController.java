package com.haojing.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiange
 * @date 2020/6/29 10:40
 */
@RestController
@RequestMapping("/system")
public class TestController {

    @RequestMapping("/get")
    public String test(){
        System.out.println("test");
        return "success";
    }
}
