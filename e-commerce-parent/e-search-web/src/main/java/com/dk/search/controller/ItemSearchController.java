package com.dk.search.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dk.search.service.ItemSearchService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author DingKai
 * @Classname ItemSearchController
 * @Description TODO
 * @create 2019/4/11
 */
@RestController
@RequestMapping("/itemsearch")
public class ItemSearchController {

    /**
     * 远程注入ItemSearchService服务
     */
    @Reference
    private ItemSearchService itemSearchService;

    @RequestMapping("/search")
    public Map<String, Object> search(@RequestBody Map searchMap) {
        System.out.println("ItemSearchController.search");
        return itemSearchService.search(searchMap);
    }

}
