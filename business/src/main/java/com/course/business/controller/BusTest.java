package com.course.business.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 路由测试
 * @author jiange
 * @date 2020/6/30 11:13
 */
@RestController
@RequestMapping("/bus")
public class BusTest {

    @RequestMapping("/test")
    public String getStr(){
        return "bus test";
    }
}
