package org.zz.demo1.service;

import org.zz.demo1.domain.entity.Orders;

import java.util.List;

public interface OrdersService {
    public List<Orders> findByUserId(Long userId);

    public boolean save(Orders order);

    public Orders findById(Long id);
}