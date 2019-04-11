package com.dk.search.service;

import java.util.Map;

/**
 * @author DingKai
 * @Classname ItemSearchService
 * @Description 搜索服务接口
 * @create 2019/4/11
 */
public interface ItemSearchService {
    
    /**
     * 搜索
     */
    Map<String, Object> search(Map searchMap);
}
