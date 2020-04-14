package com.cn.ONeutralSpringBootWeb.dao;

import com.cn.ONeutralSpringBootWeb.pojo.BlogInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {

    List<BlogInfo> searchTitle(String searchKey);

    List<BlogInfo> searchBlogs(String searchKey);
}
