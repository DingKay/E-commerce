package com.dk.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dk.sellergoods.service.UserService;

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
      * 测试：远程调用该方法,返回list集合
      * @author DingKai
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
