package com.dk.portal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dk.content.service.ContentService;
import com.dk.domain.TbContent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DingKai
 * @Classname ContentController
 * @Description TODO
 * @create 2019/4/4
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    /**
     * 远程注入ContentService对象
     */
    @Reference
    private ContentService contentService;

    @RequestMapping("/findContentByCategoryId")
    public List<TbContent> findContentByCategoryId(long categoryId){
        return contentService.findContentByCategoryId(categoryId);
    }
}
