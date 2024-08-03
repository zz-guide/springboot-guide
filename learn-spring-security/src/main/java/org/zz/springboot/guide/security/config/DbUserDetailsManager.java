package org.zz.springboot.guide.security.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DbUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService {
    public static final Map<Long, org.zz.demo3.domain.User> users = new LinkedHashMap<>();

    // 模拟数据库
    static {
        org.zz.demo3.domain.User user = org.zz.demo3.domain.User.builder()
                .id(1L)
                .username("zhangsan")
                .name("张三")
                .password(passwordEncoder().encode("123456"))
                .build();
        users.put(user.getId(), user);
        System.out.println(user);
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return null;
    }

    @Override
    public void createUser(UserDetails user) {
        org.zz.demo3.domain.User lastUser = null;
        for (Map.Entry<Long, org.zz.demo3.domain.User> userEntry : users.entrySet()) {
            org.zz.demo3.domain.User value = userEntry.getValue();
            if (value.getUsername().equals(user.getUsername())) {
                throw new IllegalArgumentException("user should not exist");
            }

            lastUser = value;
        }

        // 模拟插入数据库
        org.zz.demo3.domain.User userEntity = org.zz.demo3.domain.User.builder()
                .username(user.getUsername())
                .password(passwordEncoder().encode(user.getPassword()))
                .build();

        if (lastUser == null) {
            userEntity.setId(1L);
        } else {
            userEntity.setId(lastUser.getId()+1);
        }

        users.put(userEntity.getId(), userEntity);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username:" + username);

        org.zz.demo3.domain.User user = null;
        for (Map.Entry<Long, org.zz.demo3.domain.User> longUserEntry : users.entrySet()) {
            org.zz.demo3.domain.User value = longUserEntry.getValue();
            if (value.getUsername().equals(username)) {
                user = value;
            }
        }

        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 模拟从数据库中获取权限
        authorities.add(() -> "USER_LIST");
        authorities.add(() -> "USER_CREATE");
        System.out.println("asdasd");
        // 可基于属性进行扩展,比如账号是否可用，过没过期，等
        return new User(user.getUsername(),
                passwordEncoder().encode(user.getPassword()),
                true, // user.isEnabled(), 账号是否可用
                true, // user.isAccountNonExpired(), 未过期
                true, // user.isCredentialsNonExpired(), 用户凭证未过期
                true, //  user.isAccountNonLocked(), 用户账户未被锁定了
                authorities //  user.getAuthorities(), 权限列表
        );
    }

    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
