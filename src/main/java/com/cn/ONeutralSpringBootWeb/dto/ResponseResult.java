package com.cn.ONeutralSpringBootWeb.dto;

import lombok.Data;

/**
 * MarkDown文件上传
 */
@Data
public class ResponseResult {
    private Integer success;
    private String Message;
    private String url;

    public void setSuccess(int i) {
        this.success=i;
    }

    public void setUrl(String url) {
        this.url=url;
    }

    public void setMessage(String msg) {
        this.Message=msg;
    }
}
