package org.zz.springboot.guide.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zz.springboot.guide.mp.entity.Address;
import org.zz.springboot.guide.mp.mapper.AddressMapper;
import org.zz.springboot.guide.mp.service.AddressService;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

}
