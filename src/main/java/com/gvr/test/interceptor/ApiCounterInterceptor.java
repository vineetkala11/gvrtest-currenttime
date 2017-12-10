package com.gvr.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gvr.test.model.Session;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApiCounterInterceptor implements HandlerInterceptor{

    @Autowired Session session;
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception arg3)
            throws Exception {
        
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        // TODO Auto-generated method stub
        log.info(request.getQueryString());
        log.info(request.getContextPath());
        log.info(request.getRequestURI());
        log.info(request.getMethod());
        log.info(request.getServletPath());
        session.updateHitCount(Session.API.Time);
        return true;
    }

}
