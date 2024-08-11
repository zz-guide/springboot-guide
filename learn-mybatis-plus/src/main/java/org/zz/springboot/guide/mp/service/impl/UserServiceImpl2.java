package org.zz.springboot.guide.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zz.springboot.guide.mp.entity.User;
import org.zz.springboot.guide.mp.mapper.UserMapper;

@Service(value="userServiceImpl2")
public class UserServiceImpl2 extends ServiceImpl<UserMapper, User> implements IService<User> {

}
