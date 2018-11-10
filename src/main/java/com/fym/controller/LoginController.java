package com.fym.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {


    /**
     *  登录实现
     * @param name 用户名
     * @param psw 密码
     * @param cip IP
     * @param cname  详细地点
     * @return
     */
    @RequestMapping("/login")
    public Map<String,Object> login(String name,String psw,String cip,String cname){


        return null;
    }
}
