package org.zz.demo1.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zz.demo1.common.ResponseResult;
import org.zz.demo1.domain.entity.Orders;
import org.zz.demo1.domain.api.orders.OrdersCreateRequest;
import org.zz.demo1.domain.api.orders.OrdersInfoRequest;
import org.zz.demo1.service.OrdersService;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    private OrdersService orderService;


    @PostMapping("/create")
    public ResponseResult<?> create(@Validated @RequestBody OrdersCreateRequest params) {
        var order = Orders.builder().userId(params.getUserId()).sn(UUID.randomUUID().toString()).build();
        if (!orderService.save(order)) {
            return ResponseResult.fail("创建用户订单失败，请重试");
        }

        return ResponseResult.success();
    }

    @GetMapping("/info")
    public ResponseResult<?> orderList(@Valid OrdersInfoRequest params) {
        var user = orderService.findById(params.getId());
        return ResponseResult.success(user);
    }
}
