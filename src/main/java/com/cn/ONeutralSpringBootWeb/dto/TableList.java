package com.cn.ONeutralSpringBootWeb.dto;

import lombok.Data;

/**
 * 返回BootstrapTable的数据
 */
@Data
public class TableList {
    private Integer total;
    private Object rows;

    public void setTotal(int total) {
        this.total=total;
    }


}
