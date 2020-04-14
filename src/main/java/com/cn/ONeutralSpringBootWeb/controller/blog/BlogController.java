package com.cn.ONeutralSpringBootWeb.controller.blog;

import com.cn.ONeutralSpringBootWeb.pojo.BlogInfo;
import com.cn.ONeutralSpringBootWeb.service.ArchiveService;
import com.cn.ONeutralSpringBootWeb.service.BlogService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BlogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private BlogService blogService;

    @Autowired
    private ArchiveService archiveService;

    @RequestMapping("/")
    public String index(HttpServletRequest request){
        return this.page(request,0 );
    }
    @RequestMapping("/show")
    public String show(){
        return "blog/show";
    }

    @RequestMapping("/all_sort")
    public String allSort(){
        return "blog/all_sort";
    }

    @GetMapping("/archive")
    public String archive(@RequestParam(required = false,value = "year") String year){
        return "blog/archive";
    }

    @GetMapping("/page/{pageNum}")
    public String page(HttpServletRequest request, @PathVariable("pageNum") Integer pageNum){
        List<BlogInfo> blogList = blogService.blogList(pageNum);
        PageInfo pageInfo = new PageInfo(blogList);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("titleBlogs", blogService.getRecentBlogs());
        request.setAttribute("viewsBlogs", blogService.getMostViewsBlogs());
        request.setAttribute("archive",archiveService.findAchiveByYear());
        return "blog/index";
    }

    @GetMapping("/register")
    public String register(){
        return "admin/register";
    }

    @GetMapping("/show/{blogId}")
    public String show(HttpServletRequest request,@PathVariable("blogId") Integer blogId){
        BlogInfo blogInfo = blogService.showBlog(blogId);
        request.getSession().setAttribute("username",blogInfo.getAuthor() );
        request.setAttribute("blogInfo", blogInfo);
        return "blog/show";
    }
}
