package com.cn.ONeutralSpringBootWeb.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Comment {
    private Integer id;
    private Integer articleId;
    private String commentName;
    private String comment;
    private String articleTitle;
    private String replay;
    private Date createBy;
    private String createByStr;
    private Date replayCreateBy;
    private Integer isDelete;

    public Date getCreateBy() {
        return this.createBy;
    }

    public void setCreateByStr(String date2String) {
        this.createByStr=date2String;
    }
}
