package org.zz.demo1.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zz.demo1.domain.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,username,password) values(#{name}, #{username}, #{password})")
    public int save(User user);

    @Select("select * from user where username = #{username};")
    public User findByUsername(String username);

    @Select("select * from user where id = #{id};")
    @Results(id="orderResultMap", value = {
            @Result(property = "id", column = "id", id=true),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "orderList", column = "id", javaType = List.class, many=@Many(select = "org.zz.demo1.mapper.OrdersMapper.findByUserId",
                    fetchType = FetchType.DEFAULT))
    })
    public User findById(Long id);
}