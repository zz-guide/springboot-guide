package org.zz.demo1.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.zz.demo1.domain.entity.Orders;
import org.zz.demo1.mapper.OrdersMapper;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> findByUserId(Long userId) {
        return ordersMapper.findByUserId(userId);
    }

    @Override
    public boolean save(Orders order) {
        int affectedRows = ordersMapper.save(order);
        return affectedRows > 0;
    }

    @Override
    public Orders findById(Long id) {
        return ordersMapper.findById(id);
    }
}
