package com.java.springboot04webrestfulcrud.controller;

import com.java.springboot04webrestfulcrud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello( @RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "helloWorld";
    }

    @RequestMapping("/success")
    public String success(Map<String ,Object> map){
        map.put("hello","您好");
        // 在 /templates/success.html
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }

/*    @RequestMapping("/")
    public String index(){
        return "index";
    }*/
}
