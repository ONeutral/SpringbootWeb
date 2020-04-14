package com.cn.ONeutralSpringBootWeb.service;

import com.cn.ONeutralSpringBootWeb.pojo.BlogInfo;

import java.util.List;
import java.util.Map;

public interface ArchiveService {

    /**
     * 归档
     * @return
     */
    Map<String,Integer> findAchiveByYear();

    /**
     * 根据年份搜索博客
     * @param year
     * @return
     */
    List<BlogInfo> findByYear(String year);
}
