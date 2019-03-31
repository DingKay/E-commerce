package com.dk.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dk.sellergoods.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DingKai
 * @Classname TestController
 * @Description TODO
 * @create 2019/3/31
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Reference
    private UserService userService;

    /**
      * @author DingKai
      * @Description 测试远程调用获取list集合
      * @Date 2019/3/31
      * @Param []
      * @return java.util.List
      */
    @RequestMapping("/get")
    public List getList(){
        System.out.println("TestController.getList");
        List list = userService.getList();
        return list;
    }
}
