package org.zz.demo1.controller;

import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.zz.demo1.common.ResponseResult;
import org.zz.demo1.domain.request.*;

import java.util.HashMap;

@RestController
@RequestMapping("/valid")
public class ValidController {

    /**
     * query形式传参，形参是get请求参数
     * 1. 不会自动校验参数合法
     * 2. 不传name默认为null
     * 3. 127.0.0.1:8999/valid/get?name=, 这种情况下name是空字符串，而不是null
     * 4.
     */
    @GetMapping("/get")
    public ResponseResult<?> get(String name) {
        System.out.println("name:" + name);
        if (StringUtils.isBlank(name)) {
            name = "默认为空";
        }

        return ResponseResult.success(name);
    }

    /**
     *  路径形式传参，形参是get请求参数
     * 1. 此种方式下参数必传，否则会抛出异常 No static resource valid/get1；可通过required属性控制
     * 2. 只有空格也会抛异常
     * 3. 不会自动校验参数合法
     */
    @GetMapping("/get1/name/{name}/age/{age}")
    public ResponseResult<?> get1(@PathVariable(value = "name", required = false) String name, @PathVariable(value="age", required = false) Integer age) {
        System.out.println("name:" + name);
        System.out.println("age:" + age);
        if (StringUtils.isBlank(name)) {
            name = "默认为空";
        }

        var map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("age", age);
        return ResponseResult.success(map);
    }

    /**
     * query形式传参，形参是get请求参数， 实体类接收,不自动校验
     *
     */
    @GetMapping("/get2")
    public ResponseResult<?> get2(ValidGet2 params) {
        System.out.println("params:" + params.toString());
        return ResponseResult.success(params);
    }

    /**
     * query形式传参，形参是get请求参数， 实体类接收,自动校验
     *
     */
    @GetMapping("/get3")
    public ResponseResult<?> get3(@Valid ValidGet3 params) {
        System.out.println("params:" + params.toString());
        return ResponseResult.success(params);
    }

    /**
     * PathVariable 只能映射到单个变量上，不能映射到类上
     */
    @GetMapping("/get4/{name}/{age}")
    public ResponseResult<?> get4(@PathVariable ValidGet4 params) {
        System.out.println("params:" + params.toString());
        return ResponseResult.success(params);
    }

    /**
     * query形式传参，形参是get请求参数，不自动校验
     * 1. RequestParam 默认为require,还可以设置默认值,还可以修改参数名称
     * 2. 不支持绑定参数到实体类。
     */
    @GetMapping("/get5")
    public ResponseResult<?> get5(@RequestParam(value = "name1", defaultValue = "123") String name) {
        System.out.println("name:" + name);
        return ResponseResult.success(name);
    }

    /**
     * post请求，application/json形式
     * 1. 支持实体类和单个值接收，需要符合json规范
     * 2. 同一个请求@RequestBody只能定义一个
     * 3. 默认为true，可通过required=false修改
     */
    @PostMapping("/post")
    public ResponseResult<?> post(@RequestBody(required=false) String name) {
        System.out.println("name:" + name);
        return ResponseResult.success(name);
    }

    /**
     * post请求，application/json形式
     * 1. 默认情况下body体至少应该是一个{}，不能什么也没有
     */
    @PostMapping("/post1")
    public ResponseResult<?> post1(@RequestBody ValidPost1 params) {
        System.out.println("params:" + params.toString());
        return ResponseResult.success(params);
    }

    /**
     * post请求，application/json形式
     */
    @PostMapping("/post2")
    public ResponseResult<?> post2(@RequestBody @Valid ValidPost2 params) {
        System.out.println("params:" + params.toString());
        return ResponseResult.success(params);
    }
}
