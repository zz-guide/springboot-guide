package org.zz.springboot.guide.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zz.springboot.guide.mp.entity.RUser;
import org.zz.springboot.guide.mp.mapper.RUserMapper;
import org.zz.springboot.guide.mp.service.RUserService;

@Service
public class RUserServiceImpl extends ServiceImpl<RUserMapper, RUser> implements RUserService {

}
