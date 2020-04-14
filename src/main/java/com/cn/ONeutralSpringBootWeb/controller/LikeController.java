package com.cn.ONeutralSpringBootWeb.controller;

import com.cn.ONeutralSpringBootWeb.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LikeController {

    @Autowired
    private LikeService likeService;
    @PostMapping("/getLikeStatus")
    @ResponseBody
    public Integer getLikeStatus(@RequestParam("articleId")Integer articleId){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return likeService.getLikeStatus(username,articleId);
    }
    @PostMapping("/likeStatus")
    @ResponseBody
    public String likeStatus(@RequestParam("status") Integer status,@RequestParam("articleId") Integer articleId){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (status == 0){
            likeService.unLiked2Redis(username,articleId);
            likeService.decrementLikedCount(String.valueOf(articleId));
            return "取消点赞";
        }else{
            likeService.saveLiked2Redis(username,articleId);
            likeService.incrementLikedCount(String.valueOf(articleId));
            return "点赞";
        }
    }
    @PostMapping("/getLikedCountById")
    @ResponseBody
    public Integer getLikedCountById(@RequestParam("articleId") Integer articleId){
        return likeService.getLikedCountByIdFromRedis(articleId);
    }
}
