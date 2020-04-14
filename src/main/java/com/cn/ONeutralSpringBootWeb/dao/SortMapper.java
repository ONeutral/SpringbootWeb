package com.cn.ONeutralSpringBootWeb.dao;

import com.cn.ONeutralSpringBootWeb.pojo.BlogInfo;
import com.cn.ONeutralSpringBootWeb.pojo.Sort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SortMapper {

    List<BlogInfo> sortBlog(String sortName);

    List<Sort> getAllSorts();

    int addSort(String sortName);

    List<Sort> sorts(@Param("limit") Integer limit, @Param("offset") Integer offset);

    int getTotalSorts();

    List<Sort> editorSorts();

    void sortToArticle(@Param("sortId")Integer sortId,@Param("articleId")Integer articleId);

    int updateSortNum(@Param("sortId") Integer sortId,@Param("isDelete") Integer isDelete);

    int delSort(Integer id);

    List<Integer> articleIdToSortId(Integer articleId);

}
