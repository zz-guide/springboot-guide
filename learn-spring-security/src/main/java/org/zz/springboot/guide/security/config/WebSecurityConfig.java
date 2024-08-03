package org.zz.springboot.guide.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // 基于数据库的用户认证
        DbUserDetailsManager manager = new DbUserDetailsManager();
        return manager;
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        // 基于内存的用户认证
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        UserDetails u = User.builder()
//                .username("zz")
//                .password(new BCryptPasswordEncoder().encode("123456"))
//                .roles("USER")
//                .build();
//        manager.createUser(u);
//        return manager;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 默认安全配置
        http.authorizeHttpRequests(authorize -> authorize
                        // 对所有请求开启授权保护
                        .anyRequest()
                        // 已进行认证的用户自动进行授权
                        .authenticated()
                )
                //  默认的登录表单页
                .formLogin(customizer -> customizer
                        .loginPage("/login")
                        .successForwardUrl("/")
                        .permitAll()
                );
        // 基本授权方式，浏览器自带的，无法自动退出，只能清空浏览器缓存实现退出
        // .httpBasic(withDefaults());
        // 跨域
        http.cors(withDefaults());
//        http.csrf(AbstractHttpConfigurer::disable);
        // 同一个账号最多只能存在一个session
//        http.sessionManagement(session-> session.maximumSessions(1).expiredSessionStrategy(new MySessionInformationExpiredStrategy()));
        return http.build();
    }
}