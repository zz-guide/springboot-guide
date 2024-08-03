package org.zz.springboot.guide.satoken.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;


@RestController
@RequestMapping("/kikOut")
public class KickOutController {

    @RequestMapping("logout")
    public SaResult logout(long userId) {
        StpUtil.logout(userId);
        return SaResult.ok("主动退出登录");
    }

    @RequestMapping("kikOut")
    public SaResult kickOut(long userId) {
        // 踢人下线不会清除Token信息，而是将其打上特定标记，再次访问会提示：Token已被踢下线。

        // 可以根据token值踢人
        // 可以根据id踢人
        StpUtil.kickout(userId);
//        StpUtil.kickoutByTokenValue(tokenValue);
        return SaResult.ok();
    }
}
