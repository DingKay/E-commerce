package com.dk.sellergoods.service;

import com.dk.domain.TbBrand;
import com.dk.entity.PageResult;

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

    /**
      * 分页的方法
      * @author DingKai
      * @Date 2019/3/31
      * @Param
      * @return
      */
    PageResult findPage(int pageNum, int pageSize);
}
