package org.zz.demo1.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.zz.demo1.domain.entity.User;
import org.zz.demo1.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public boolean save(User user) {
        int affectedRows = userMapper.save(user);
        return affectedRows > 0;
    }
}
