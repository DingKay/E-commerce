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
     * 搜索接口方法
     * @author DingKai
     * @date 2019/4/11
     * @param searchMap
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @exception
     */
    Map<String, Object> search(Map searchMap);
}
