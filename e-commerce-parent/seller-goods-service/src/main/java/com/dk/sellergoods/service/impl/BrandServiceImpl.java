package com.dk.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dk.dao.TbBrandMapper;
import com.dk.domain.TbBrand;
import com.dk.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author DingKai
 * @Classname BrandServiceImpl
 * @Description 品牌服务实现类
 * @create 2019/3/31
 */
@Service
public class BrandServiceImpl implements BrandService {

    /**
      * 注入TbBrandMapper dao 对象
      * @author DingKai
      */
    @Autowired
    private TbBrandMapper tbBrandMapper;

    /**
      * 查询所有品牌方法
      * @author DingKai
      * @Date 2019/3/31
      * @Param []
      * @return java.util.List<com.dk.domain.TbBrand>
      */
    @Override
    public List<TbBrand> findAll() {
        System.out.println("BrandServiceImpl.findAll");
        //调用mapper里面的方法查询所有品牌, null代表查询所有。
        List<TbBrand> tbBrands = tbBrandMapper.selectByExample(null);
        return tbBrands;
    }
}
