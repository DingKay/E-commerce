package com.dk.content.service;

import com.dk.domain.TbContent;

import java.util.List;

/**
 * @author DingKai
 * @Classname ContentService
 * @Description TODO
 * @create 2019/4/4
 */
public interface ContentService {
    
    /**
     * 根据广告类别查询广告信息接口
     * @author DingKai
     * @date 2019/4/4
     * @param
     * @return java.util.List<com.dk.domain.TbContent>
     * @exception 
     */
    List<TbContent> findContentByCategoryId(long categoryId);
}
