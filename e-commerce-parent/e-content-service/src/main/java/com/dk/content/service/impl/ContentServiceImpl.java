package com.dk.content.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dk.content.service.ContentService;
import com.dk.dao.TbContentMapper;
import com.dk.domain.TbContent;
import com.dk.domain.TbContentExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author DingKai
 * @Classname ContentServiceImpl
 * @Description TODO
 * @create 2019/4/4
 */
@Service
public class ContentServiceImpl implements ContentService {

    /**
     * Logger初始化
     */
    private static final Logger logger = LoggerFactory.getLogger(ContentServiceImpl.class);

    /**
     * 自动装配TbContentMapper对象
     */
    @Autowired
    private TbContentMapper tbContentMapper;


    /**
     * 根据产品分类Id查询广告信息实现方法
     * @author DingKai
     * @date 2019/4/4
     * @param categoryId
     * @return java.util.List<com.dk.domain.TbContent>
     * @exception 
     */
    @Override
    public List<TbContent> findContentByCategoryId(long categoryId) {
        //返回值
        List<TbContent> tbContents = null;
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        //拼接条件 类别id
        criteria.andCategoryIdEqualTo(categoryId);
        //拼接条件 状态1表示可使用
        criteria.andStatusEqualTo("1");
        //拼接条件 排序
        example.setOrderByClause("sort_order");
        try {
            tbContents = tbContentMapper.selectByExample(example);
        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return tbContents;
    }
}
