package org.zz.springboot.guide.satoken.controller;

import cn.dev33.satoken.stp.SaLoginConfig;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {
    @RequestMapping("login")
    public SaResult login(String username, String password) {
        if ("zz123".equals(username) && "123456".equals(password)) {
            if (StpUtil.isLogin()) {
                return SaResult.ok("已经登录");
            }

            StpUtil.login(10001, SaLoginConfig.setExtra("name", "仔仔").setExtra("age", 23));
            return SaResult.ok("登录成功");
        }

        return SaResult.error("登录失败");
    }

    @RequestMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("当前会话是否登录：" + StpUtil.isLogin());
    }

    @RequestMapping("checkLogin")
    public SaResult checkLogin() {
        // 检验当前会话是否已经登录, 如果未登录，则抛出异常：`NotLoginException`
        StpUtil.checkLogin();

        // 抛出异常后，代码将走入全局异常处理（GlobalException.java），如果没有抛出异常，则代表通过了登录校验，返回下面信息
        return SaResult.ok("校验登录成功，这行字符串是只有登录后才会返回的信息");
    }

    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    @RequestMapping("logout")
    public SaResult logout(Long userId) {
        if (userId != null) {
            StpUtil.logout(userId);
        } else {
            StpUtil.logout();
        }
        return SaResult.ok("主动退出登录(强制注销)");
    }

    @RequestMapping("kikout")
    public SaResult kickOut(Long userId) {
        // 踢人下线不会清除Token信息，而是将其打上特定标记，再次访问会提示：Token已被踢下线。
        // 可以根据token值踢人
        // 可以根据id踢人


        // 提示: token 已被踢下线：9d6986dc-8116-4450-b885-4d912f551627
        StpUtil.kickout(userId);
//        StpUtil.kickoutByTokenValue(tokenValue);
        return SaResult.ok();
    }
}
