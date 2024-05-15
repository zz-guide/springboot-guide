package org.zz.demo5.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zz.demo5.domain.RUser;
import org.zz.demo5.mapper.RUserMapper;
import org.zz.demo5.service.RUserService;

@Service
public class RUserServiceImpl extends ServiceImpl<RUserMapper, RUser> implements RUserService {

}
