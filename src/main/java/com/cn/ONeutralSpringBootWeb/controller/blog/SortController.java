package com.cn.ONeutralSpringBootWeb.controller.blog;

import com.cn.ONeutralSpringBootWeb.pojo.BlogInfo;
import com.cn.ONeutralSpringBootWeb.pojo.Sort;
import com.cn.ONeutralSpringBootWeb.service.BlogService;
import com.cn.ONeutralSpringBootWeb.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SortController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private SortService sortService;

    @PostMapping("/allSorts")
    @ResponseBody
    public List<Sort> allSorts(){
        return sortService.getAllSorts();
    }

//    @GetMapping("/sort/{sortId}")
//    public String sort(HttpServletRequest request, @PathVariable("sortId")String sortId){
//        request.getSession().setAttribute("sortId", sortId);
//        return this.sortPage(request,0);
//    }

//    @GetMapping("/sortPage/{pageNum}")
//    public String sortPage(HttpServletRequest request, @PathVariable("pageNum") Integer pageNum){
//        Integer sortId = Integer.parseInt((String) request.getSession().getAttribute("sortId"));
//        List<BlogInfo> blogList = sortService.sortBlog(sortId,pageNum);
//        PageInfo pageInfo = new PageInfo(blogList);
//        request.setAttribute("pageInfo", pageInfo);
//        request.setAttribute("titleBlogs", blogService.getRecentBlogs());
//        request.setAttribute("viewsBlogs", blogService.getMostViewsBlogs());
//        return "blog/sort";
//    }

    @PostMapping("/sortToBlog")
    @ResponseBody
    public List<BlogInfo> sortToBlog(String sortName){
        return sortService.sortToBlog(sortName);
    }
}
