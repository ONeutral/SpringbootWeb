package com.cn.ONeutralSpringBootWeb.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class BlogContent {
    private Integer id;
    private String articleContent;
    private Integer articleId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date modifiedBy;
}
