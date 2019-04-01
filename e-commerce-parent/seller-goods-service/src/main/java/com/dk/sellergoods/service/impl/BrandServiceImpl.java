package com.dk.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dk.dao.TbBrandMapper;
import com.dk.domain.TbBrand;
import com.dk.entity.PageResult;
import com.dk.sellergoods.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);

    /**
     * 注入TbBrandMapper dao 对象
     */
    @Autowired
    private TbBrandMapper tbBrandMapper;

    /**
     * 查询所有品牌方法实现方法
     * @author DingKai
     * @date 2019/3/31
     * @return java.util.List<com.dk.domain.TbBrand>
     */
    @Override
    public List<TbBrand> findAll() {
        logger.debug("BrandServiceImpl.findAll## 查询品牌表中所有 start");
        //调用mapper里面的方法查询所有品牌, null代表查询所有。
        List<TbBrand> tbBrands = tbBrandMapper.selectByExample(null);
        return tbBrands;
    }

    /**
     * 分页方法实现方法
     * @author DingKai
     * @date 2019/3/31
     * @param pageNum
     * @param pageSize
     * @return com.dk.entity.PageResult
     */
    @Override
    public PageResult page(int pageNum, int pageSize) {
        logger.debug("BrandServiceImpl.findPage## 分页实现类 start");
        //使用PageHelper插件
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page = (Page<TbBrand>)tbBrandMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 新增品牌实现方法
     * @author DingKai
     * @date 2019/4/1
     * @param tbBrand
     * @return void
     * @exception 
     */
    @Override
    public void add(TbBrand tbBrand) {
        tbBrandMapper.insert(tbBrand);
    }

    /**
     * 根据主键id更新品牌实现方法
     * @author DingKai
     * @date 2019/4/1
     * @param tbBrand
     * @return void
     * @exception
     */
    @Override
    public void update(TbBrand tbBrand) {
        tbBrandMapper.updateByPrimaryKey(tbBrand);
    }

    /**
     * 查询品牌实现方法
     * @author DingKai
     * @date 2019/4/1
     * @param id
     * @return com.dk.domain.TbBrand
     * @exception
     */
    @Override
    public TbBrand findOne(long id) {
        TbBrand tbBrand = tbBrandMapper.selectByPrimaryKey(id);
        return tbBrand;
    }

    /**
     * 批量删除实现方法
     * @author DingKai
     * @date 2019/4/1
     * @param ids
     * @return void
     * @exception
     */
    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }
}
