package com.dk.sellergoods.service;

import com.dk.domain.TbBrand;

import java.util.List;

/**
 * @author DingKai
 * @Classname BrandService
 * @Description 品牌接口
 * @create 2019/3/31
 */
public interface BrandService {
    /**
      * 查询所有品牌接口
      * @author DingKai
      * @Date 2019/3/31
      * @Param []
      * @return java.util.List<com.dk.domain.TbBrand> 
      */
    List<TbBrand> findAll();
}
