package com.dk.content.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dk.content.service.ContentService;
import com.dk.dao.TbContentMapper;
import com.dk.domain.TbContent;
import com.dk.domain.TbContentExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

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
     * Redis缓存对象
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据产品分类Id查询广告信息实现方法
     *
     * @param categoryId
     * @return java.util.List<com.dk.domain.TbContent>
     * @throws
     * @author DingKai
     * @date 2019/4/4
     */
    @Override
    public List<TbContent> findContentByCategoryId(long categoryId) {
        //从redis中读取广告信息，如果不存在，则从数据库中读取数据
        List<TbContent> contentList = (List<TbContent>) redisTemplate.boundHashOps("content").get(categoryId);
        if (contentList == null) {
            //返回值
            TbContentExample example = new TbContentExample();
            TbContentExample.Criteria criteria = example.createCriteria();
            //拼接条件 类别id
            criteria.andCategoryIdEqualTo(categoryId);
            //拼接条件 状态1表示可使用
            criteria.andStatusEqualTo("1");
            //拼接条件 排序
            example.setOrderByClause("sort_order");
            try {
                contentList = tbContentMapper.selectByExample(example);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            //存入缓存
            redisTemplate.boundHashOps("content").put(categoryId, contentList);
        } else {
            System.out.println("从缓存读取数据");
        }

        return contentList;
    }
}
