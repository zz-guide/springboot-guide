package org.zz.demo1.service;

import org.zz.demo1.domain.entity.User;

public interface UserService {
    public User findById(Long id);

    public User findByUsername(String username);

    public boolean save(User user);
}