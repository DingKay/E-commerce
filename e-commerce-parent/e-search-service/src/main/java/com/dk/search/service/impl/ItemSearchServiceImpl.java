package com.dk.search.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dk.domain.TbItem;
import com.dk.search.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DingKai
 * @Classname ItemSearchServiceImpl
 * @Description 搜索服务实现类
 * 由于搜索操作可能相比较其他服务会比较耗时，
 * 所以此接口类设置接口超时时间。
 * @create 2019/4/11
 */
@Service(timeout=3000)
public class ItemSearchServiceImpl implements ItemSearchService {

    /**
     * solr操作对象
     */
    @Autowired
    private SolrTemplate solrTemplate;

    /**
     * 搜索方法
     * @author DingKai
     * @date 2019/4/11
     * @param searchMap
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @exception
     */
    @Override
    public Map<String, Object> search(Map searchMap) {
        System.out.println("ItemSearchServiceImpl.search");
        Map<String,Object> map = new HashMap<>();
        Query query = new SimpleQuery();
        //添加查询条件
        Criteria criteria=new Criteria("item_keywords").is(searchMap.get("keywords"));
        query.addCriteria(criteria);
        ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);
        map.put("rows", page.getContent());
        return map;
    }
}
