package com.dk.solr.util;

import com.alibaba.fastjson.JSON;
import com.dk.dao.TbItemMapper;
import com.dk.domain.TbItem;
import com.dk.domain.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author DingKai
 * @Classname SolrUtil
 * @Description TODO
 * @create 2019/4/11
 */
@Component
public class SolrUtil {

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private SolrTemplate solrTemplate;

    public void importItemData(){

        TbItemExample example=new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        //审核通过的才导入的
        criteria.andStatusEqualTo("1");
        List<TbItem> itemList = itemMapper.selectByExample(example);

        System.out.println("---商品列表---");
        for(TbItem item:itemList){
            System.out.println(item.getId()+" "+ item.getTitle()+ " "+item.getPrice());
            //从数据库中提取规格json字符串转换为map
            Map specMap = JSON.parseObject(item.getSpec(), Map.class);
            item.setSpecMap(specMap);
        }

        solrTemplate.saveBeans(itemList);
        solrTemplate.commit();

        System.out.println("---结束---");
    }

    public static void main(String[] args) {

        ApplicationContext context=new ClassPathXmlApplicationContext("classpath*:spring/applicationContext*.xml");
        SolrUtil solrUtil=  (SolrUtil) context.getBean("solrUtil");
        solrUtil.importItemData();
    }
}
