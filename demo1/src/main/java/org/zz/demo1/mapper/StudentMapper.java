package org.zz.demo1.mapper;

import org.apache.ibatis.annotations.*;
import org.zz.demo1.domain.entity.Student;
import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from student")
    public List<Student> findAll();

    @Select("select * from student where id = #{id};")
    public Student findById(Long id);

    @Insert("insert into student (name,age) values(#{name}, #{age})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int save(Student student);

    @Update("update student set name=#{name},age=#{age} where id=#{id}")
    public int update(Student student);

    @Delete("delete from student where id=#{id}")
    public int delete(Long id);

    @Select("select * from student where name = #{name};")
    public Student findByName(String name);
}