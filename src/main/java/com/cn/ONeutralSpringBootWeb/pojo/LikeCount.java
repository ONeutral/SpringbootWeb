package com.cn.ONeutralSpringBootWeb.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LikeCount {
    private Integer articleId;
    private Integer likeNum;

    public LikeCount() {
    }

    public LikeCount(Integer articleId, Integer likeNum) {
        this.articleId = articleId;
        this.likeNum = likeNum;
    }
}
