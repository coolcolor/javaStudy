package cn.cool.springboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "你好，世界";
    }

    @GetMapping("/world")
    public String world() {
        return "123";
    }

    @RequestMapping("/")
    public ModelAndView welcome() {
        return new ModelAndView("websocket.html");
    }
}
