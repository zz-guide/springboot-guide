package org.zz.springboot.guide.satoken.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search/")
public class SearchController {

    @RequestMapping("t1")
    @SaCheckLogin
    public SaResult t1() {
        return SaResult.ok("t1 有权限访问");
    }
}
