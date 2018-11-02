package cn.cool.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
    @RequestMapping("hello")
    public String hello(Map<String, Object> map) {
        map.put("msg", "hellothymeleaf");
        return "hello";
    }
}
