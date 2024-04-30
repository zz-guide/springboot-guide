package org.zz.demo1.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * filter->servlet->interceptor->aop->controller
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 在请求到达处理器之前执行，可以用于权限验证、数据校验等操作。如果返回true，则继续执行后续操作；如果返回false，则中断请求处理。

//        HttpSession session = request.getSession();
//        System.out.println("session name:" + session.getAttribute("name"));
//        System.out.println("preHandle: " + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        // 在Controller处理器处理请求之后执行，可以用于日志记录、缓存处理等操作。
        System.out.println("postHandle: " + request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 在 DispatcherServlet 渲染了对应的视图之后执行，可以用于资源清理等操作。
        System.out.println("afterCompletion: " + request.getRequestURI());
    }
}