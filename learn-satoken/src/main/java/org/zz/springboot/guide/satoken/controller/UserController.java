package org.zz.springboot.guide.satoken.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

    @RequestMapping("login")
    public SaResult login(String username, String password) {
        if("zz123".equals(username) && "123456".equals(password)) {
            if (StpUtil.isLogin()) {
                return SaResult.ok("已经登录");
            }

            StpUtil.login(10001);
            return SaResult.ok("登录成功");
        }

        return SaResult.error("登录失败");
    }

    @RequestMapping("checkLogin")
    public SaResult checkLogin() {
        return SaResult.ok("当前会话是否登录：" + StpUtil.isLogin());
    }

    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }
}
