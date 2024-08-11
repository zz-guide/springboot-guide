package org.zz.springboot.guide.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zz.springboot.guide.mp.entity.Orders;
import org.zz.springboot.guide.mp.mapper.OrdersMapper;
import org.zz.springboot.guide.mp.service.OrdersService;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

}
