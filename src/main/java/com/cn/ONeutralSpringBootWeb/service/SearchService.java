package com.cn.ONeutralSpringBootWeb.service;

import com.cn.ONeutralSpringBootWeb.dto.Result;
import com.cn.ONeutralSpringBootWeb.pojo.BlogInfo;

import java.util.List;


public interface SearchService {

    /**
     * 根据searchKey查找文章是否存在
     * @param searchKey
     * @return
     */
    Result searchTitle(String searchKey);

    /**
     *博客搜索分页
     * @param pageNum
     * @param searchKey
     * @return
     */
    List<BlogInfo> searchBlog(Integer pageNum, String searchKey);
}
