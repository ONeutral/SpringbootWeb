package com.cn.ONeutralSpringBootWeb.job;

import com.cn.ONeutralSpringBootWeb.service.BlogService;
import com.cn.ONeutralSpringBootWeb.service.LikeService;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class QuartzJob extends QuartzJobBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzJob.class);

    @Autowired
    private LikeService likeService;
    @Autowired
    private BlogService blogService;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        try {
            blogService.writeUserViews2DB();
            blogService.setView();
            likeService.saveLiked2DB();
            likeService.saveLikedCount2DB();
            blogService.writeHistoricalViews();
        } catch (Exception e) {
            LOGGER.error("任务执行出错："+e.getMessage());
        }
    }
}
