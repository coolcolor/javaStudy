package cn.cool.springboot.controller;

import cn.cool.springboot.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(value = "FastJson测试", tags = {"测试接口"})
@RestController
@RequestMapping(value = "fastjson")
//@CrossOrigin(origins = "http://localhost:63342")
public class FastJsonController {
    //@RequestMapping("/test")
    //@ResponseBody
    @ApiOperation("获取用户信息")
    @ApiImplicitParam(name = "name", value = "用户名", dataType = "String", paramType = "query")
    @GetMapping("/test/{name}")
    public User Test(@PathVariable("name") String name) {
        User user = new User();
        user.setId(1);
        user.setUsername(name);
        user.setPassword("1234");
        user.setBirthday(new Date());
        //int i=1/0;
        System.out.println(user.getUsername());
        return user;
    }
}
