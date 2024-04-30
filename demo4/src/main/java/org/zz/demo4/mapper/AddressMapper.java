package org.zz.demo4.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zz.demo4.domain.Address;
import org.zz.demo4.domain.AddressExample;

public interface AddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Address row);

    int insertSelective(Address row);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Address row, @Param("example") AddressExample example);

    int updateByExample(@Param("row") Address row, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address row);

    int updateByPrimaryKey(Address row);
}