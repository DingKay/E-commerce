package com.dk.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dk.domain.TbBrand;
import com.dk.entity.PageResult;
import com.dk.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DingKai
 * @Classname BrandController
 * @Description 商品管理服务控制器
 * @create 2019/3/31
 */
@RestController
@RequestMapping(value = "/brand")
public class BrandController {

    /**
      * 远程注入service
      * @author DingKai
      */
    @Reference
    private BrandService brandService;

    /**
      * 品牌列表
      * @author DingKai
      * @Date 2019/3/31
      * @Param null
      * @return List<TbBrand>
      */
    @RequestMapping("/findAll")
    public List<TbBrand> findAllBrand(){
        System.out.println("BrandController.findAllBrand");
        return brandService.findAll();
    }

    /**
      * 品牌分页
      * @author DingKai
      * @Date 2019/3/31
      * @Param
      * @return
      */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        System.out.println("BrandController.findPage");
        return brandService.findPage(page, rows);
    }
}
