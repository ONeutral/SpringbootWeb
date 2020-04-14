package com.cn.ONeutralSpringBootWeb.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class BlogInfo implements Serializable {
    private Integer id;
    private String author;
    private String sorts;
    private List<String> sortNames;
    private Integer sortId;
    private String articleTitle;
    private Integer articleViews;
    private String articleContent;
    private Integer articleId;
    private String imageUrl;
    private Date createBy;
    private String createByStr;
    private Date modifiedBy;
    private Integer likeNum;

    public void setArticleTitle(String articleTitle) {
        this.articleTitle=articleTitle;
    }

    public void setArticleContent(String blogContent) {
        this.articleContent=blogContent; 
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl=imageUrl;
    }

    public void setSorts(String sortIds) {
        this.sorts=sortIds;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String username) {
        this.author=username;
    }

    public Integer getId() {
        return this.id;
    }

    public void setArticleId(Integer id) {
        this.articleId=id;
    }

    public String getSorts() {
        return this.sorts;
    }

    public Date getCreateBy() {
        return this.createBy;
    }

    public void setCreateByStr(String date2String) {
        this.createByStr=date2String;
    }

    public void setSortNames(List<String> sortNames) {
        this.sortNames=sortNames;
    }

    public void setArticleViews(int number) {
        this.articleViews=number;
    }

    public String getArticleContent() {
        return this.articleContent;
    }

    public Integer getArticleViews() {
        return this.articleViews;
    }
}
