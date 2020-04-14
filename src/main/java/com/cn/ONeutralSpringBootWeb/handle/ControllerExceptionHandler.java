package com.cn.ONeutralSpringBootWeb.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**异常处理
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request ,Exception e){
        logger.error("Request URL : {} --- Exception : {}",request.getRequestURL(),e);
        ModelAndView mv = new ModelAndView();

        mv.addObject("url",request.getRequestURL() );
        mv.addObject("exception",e );
        mv.setViewName("4xx");
        return mv;
    }
}
