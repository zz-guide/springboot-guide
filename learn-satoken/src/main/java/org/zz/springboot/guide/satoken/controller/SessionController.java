package org.zz.springboot.guide.satoken.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session/")
public class SessionController {

    @RequestMapping("login")
    public SaResult login() {
        StpUtil.login(10002);
        StpUtil.getSession().set("name", "仔仔");
        return SaResult.ok("登录成功");
    }

    @RequestMapping("sessionInfo")
    public SaResult getSessionInfo() {
        String name = (String) StpUtil.getSession().get("name");
        return SaResult.data(name);
    }
}
