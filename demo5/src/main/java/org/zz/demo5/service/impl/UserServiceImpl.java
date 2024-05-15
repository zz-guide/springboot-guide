package org.zz.demo5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zz.demo5.domain.User;
import org.zz.demo5.mapper.UserMapper;
import org.zz.demo5.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
