package com.cn.ONeutralSpringBootWeb.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Replay {
    private Integer id;
    private Integer commentId;
    private String replay;
    private Date createBy;
    private Integer isDelete;
}
