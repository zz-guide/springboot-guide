package org.zz.springboot.guide.satoken.controller;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.sign.SaSignUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/sign/")
public class SignController {

    @RequestMapping("print")
    public SaResult print() {
        // 请求地址
        String url = "localhost:8999/learn_satoken/sign/addMoney";

        Map<String, Object> paramMap = new LinkedHashMap<>();
        paramMap.put("userId", 10001);
        paramMap.put("money", 1000);

        String paramStr = SaSignUtil.addSignParamsAndJoin(paramMap);

        url += "?" + paramStr;

        System.out.println("请求参数：" + url);
        return SaResult.data(url);
    }

    @RequestMapping("addMoney")
    public SaResult addMoney(long userId, long money) {
        // 1、校验请求中的签名

        // {"code":500,"msg":"timestamp 超出允许的范围：1723193414159","data":null}
        SaSignUtil.checkRequest(SaHolder.getRequest());

        // 2、校验通过，处理业务
        System.out.println("userId=" + userId);
        System.out.println("money=" + money);

        // 3、返回
        return SaResult.ok();
    }
}
