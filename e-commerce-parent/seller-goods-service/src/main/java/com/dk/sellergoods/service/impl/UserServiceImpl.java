package com.dk.sellergoods.service.impl;

import com.dk.sellergoods.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DingKai
 * @Classname UserServiceImpl
 * @Description TODO
 * @create 2019/3/31
 */
@Service
public class UserServiceImpl implements UserService {
    
    /**
      * @author DingKai
      * @Description TODO
      * @Date 2019/3/31
      * @Param []
      * @return java.util.List 
      */
    @Override
    public List getList() {
        List<String> list = new ArrayList<>();
        list.add("name:DingKay");
        list.add("age:21");
        return list;
    }
}
