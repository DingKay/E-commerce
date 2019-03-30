package com.dk.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dk.sellergoods.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DingKai
 * @Classname UserController
 * @Description TODO
 * @create 2019/3/31
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    /**
      * @author DingKai
      * @Description 调用服务层实现类获取list.
      * @Date 2019/3/31
      * @Param []
      * @return java.util.List
      */
    @RequestMapping("getList")
    public List getList(){
        List list = userService.getList();
        return list;
    }
}
