package com.dk.sellergoods.service;

import com.dk.domain.TbBrand;
import com.dk.entity.PageResult;

import java.util.List;
import java.util.logging.Logger;

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
      * @date 2019/3/31
      * @param
      * @return java.util.List<com.dk.domain.TbBrand> 
      */
    List<TbBrand> findAll();

    /**
     * 品牌分页接口
     * @author DingKai
     * @date 2019/4/1
     * @param pageNum
     * @param pageSize
     * @return com.dk.entity.PageResult
     * @exception
     */
    PageResult page(int pageNum, int pageSize);

    /**
     * 新增品牌
     * @author DingKai
     * @date 2019/4/1
     * @param tbBrand
     * @return void
     * @exception 
     */
    void add(TbBrand tbBrand);

    /**
     * 根据主键id品牌更新接口
     * @author DingKai
     * @date 2019/4/1
     * @param tbBrand
     * @return void
     * @exception 
     */
    void update(TbBrand tbBrand);

    /**
     * 查询单个品牌接口 
     * @author DingKai
     * @date 2019/4/1
     * @param id
     * @return com.dk.domain.TbBrand
     * @exception
     */
    TbBrand findOne(long id);

    /**
     * 批量删除接口
     * @author DingKai
     * @date 2019/4/1
     * @param ids
     * @return void
     * @exception
     */
    void delete(long [] ids);
}
