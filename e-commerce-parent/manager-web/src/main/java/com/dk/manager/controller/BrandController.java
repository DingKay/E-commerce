package com.dk.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dk.domain.TbBrand;
import com.dk.entity.PageResult;
import com.dk.entity.Result;
import com.dk.sellergoods.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

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
    @RequestMapping("/page")
    public PageResult page(int page, int rows){
        logger.debug("BrandController.page start");
        return brandService.page(page, rows);
    }

    /**
     * 新增品牌 
     * @author DingKai
     * @date 2019/4/1
     * @param tbBrand
     * @return com.dk.entity.Result
     * @exception 
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand tbBrand){
        Result result;
        try {
            brandService.add(tbBrand);
            result = new Result(true, "新增成功");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new Result(false, "新增失败");
        }
        return result;
    }
    
    /**
     * 修改品牌 
     * @author DingKai
     * @date 2019/4/1
     * @param tbBrand
     * @return com.dk.entity.Result
     * @exception 
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand){
        Result result;
        try {
            brandService.update(tbBrand);
            result = new Result(true, "修改成功");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new Result(false, "修改失败");
        }
        return result;
    }
    
    /**
     * 查询单个品牌信息 
     * @author DingKai
     * @date 2019/4/1
     * @param id
     * @return com.dk.domain.TbBrand
     * @exception
     */
    @RequestMapping("/findOne")
    public TbBrand findOne(long id){
        TbBrand one = brandService.findOne(id);
        return one;
    }

    /**
     * 批量删除品牌
     * @author DingKai
     * @date 2019/4/1
     * @param ids
     * @return void
     * @exception
     */
    @RequestMapping("/delete")
    public Result delete(long [] ids){
        Result result;
        try {
            brandService.delete(ids);
            result = new Result(true, "删除成功");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new Result(false, "删除失败");
        }
        return result;
    }

    /**
     * 查询品牌并分页 
     * @author DingKai
     * @date 2019/4/2
     * @param tbBrand
     * @param page
     * @param size
     * @return com.dk.entity.PageResult
     * @exception 
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand tbBrand, int page, int size){
        PageResult pages = brandService.findPage(tbBrand, page, size);
        logger.debug(pages.toString());
        return pages;
    }
}
