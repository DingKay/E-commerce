package com.dk.manager.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DingKai
 * @Classname LoginController
 * @Description 用户登录控制器
 * @create 2019/4/2
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("name")
    public Map name(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map map = new HashMap();
        map.put("loginName", name);
        return map;
    }

}
