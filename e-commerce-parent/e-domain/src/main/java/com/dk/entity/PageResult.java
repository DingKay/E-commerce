package com.dk.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author DingKai
 * @Classname PageResult
 * @Description TODO
 * @create 2019/3/31
 */
public class PageResult implements Serializable {
    /**
      * 总记录数
      * @author DingKai
      */
    private Long total;

    /**
      * 每页数据
      * @author DingKai
      */
    private List rows;

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
