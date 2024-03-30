package org.zz.demo1.mapper;

import org.apache.ibatis.annotations.*;
import org.zz.demo1.domain.entity.Orders;

import java.util.List;

@Mapper
public interface OrdersMapper {
    @Select("select * from orders where user_id = #{userId};")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "sn",property = "sn"),
            @Result(column = "user_id", property = "userId"),
    })
    public List<Orders> findByUserId(Long userId);

    @Insert("insert into orders (sn, user_id) values(#{sn}, #{userId})")
    public int save(Orders order);

    @Select("select * from orders where id = #{id};")
    public Orders findById(Long id);
}