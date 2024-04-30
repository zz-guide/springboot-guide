package org.zz.demo1.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.zz.demo1.common.ResponseResult;
import org.zz.demo1.domain.vo.UserOrderListVo;
import org.zz.demo1.domain.entity.User;
import org.zz.demo1.domain.request.UserCreateRo;
import org.zz.demo1.domain.request.UserOrderListRo;
import org.zz.demo1.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    @PostMapping("/create")
    public ResponseResult<?> create(@Valid @RequestBody UserCreateRo params) {
        if (userService.findByUsername(params.getUsername()) != null) {
            return ResponseResult.fail("账号已存在，请更换");
        }

        var user = User.builder().name(params.getName()).username(params.getUsername()).password(params.getPassword()).build();
        if (!userService.save(user)) {
            return ResponseResult.fail("创建用户失败，请重试");
        }

        return ResponseResult.success();
    }

    @GetMapping("/orderList")
    public ResponseResult<?> orderList(@Valid UserOrderListRo params) {
        System.out.println("user_id:" + params.getUserId());
        var user = userService.findById(params.getUserId());
        // 返回结果可以优化
        var res = UserOrderListVo.builder()
                .orderList(user.getOrderList())
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .password(user.getPassword())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
        return ResponseResult.success(res);
    }
}
