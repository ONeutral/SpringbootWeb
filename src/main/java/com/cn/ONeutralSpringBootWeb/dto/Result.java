package com.cn.ONeutralSpringBootWeb.dto;

import com.cn.ONeutralSpringBootWeb.pojo.Comment;
import lombok.Data;

import java.util.List;


@Data
public class Result {
    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return this.code;
    }

    public void setData(List<Comment> commentList) {
        this.data = commentList;
    }

    public void setCode(int i) { this.data=i;
    }

    public void setMessage(String msg) {this.message=msg;
    }
}
