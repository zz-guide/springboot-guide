package org.zz.demo1.mapper;

import org.apache.ibatis.annotations.*;
import org.zz.demo1.domain.entity.Teacher;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Select("select * from teacher")
    public List<Teacher> findAll();

    @Select("select * from teacher where id = #{id};")
    public Teacher findById(Long id);

    @Insert("insert into teacher (name,age) values(#{name}, #{age})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int save(Teacher teacher);

    @Update("update teacher set name=#{name},age=#{age} where id=#{id}")
    public int update(Teacher teacher);

    @Delete("delete from teacher where id=#{id}")
    public int delete(Long id);

    @Select("select * from teacher where name = #{name};")
    public Teacher findByName(String name);
}