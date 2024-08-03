package org.zz.springboot.guide.security.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MySessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        // 创建结果对象
        Map<String, Object> res = new HashMap<>();
        res.put("code", -1);
        res.put("msg", "账号已从其他设备登录");

        // 转换成json字符串
        String jsonRes = JSON.toJSONString(res);

        // 返回json响应
        HttpServletResponse response = event.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(jsonRes);
    }
}
