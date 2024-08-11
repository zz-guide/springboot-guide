package org.zz.springboot.guide.satoken.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission/")
public class PermissionController {

    @RequestMapping("t1")
    public SaResult t1() {
        System.out.println("StpUtil.hasPermission(\"user.add\"):"+ StpUtil.hasPermission("user.add"));
        System.out.println("StpUtil.hasPermission(\"art.add\"):"+ StpUtil.hasPermission("art.add"));
        System.out.println("StpUtil.hasPermission(\"*.delete\"):"+ StpUtil.hasPermission("test.delete"));
        return SaResult.ok("success");
    }
}
