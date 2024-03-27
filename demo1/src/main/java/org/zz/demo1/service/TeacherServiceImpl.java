package org.zz.demo1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zz.demo1.domain.entity.Student;
import org.zz.demo1.domain.entity.Teacher;
import org.zz.demo1.exception.MyException;
import org.zz.demo1.mapper.StudentMapper;
import org.zz.demo1.mapper.TeacherMapper;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherMapper teacherMapper;
    private final StudentMapper studentMapper;

    public TeacherServiceImpl(TeacherMapper teacherMapper, StudentMapper studentMapper) {
        this.teacherMapper = teacherMapper;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Teacher> findAll() {
        return null;
    }

    @Override
    public Teacher findById(Long id) {
        return teacherMapper.findById(id);
    }

    @Override
    public Teacher findByName(String name) {
        return teacherMapper.findByName(name);
    }

    @Override
    public boolean save(Teacher teacher) {
        int affectedRows = teacherMapper.save(teacher);
        return affectedRows > 0;
    }

    @Override
    public boolean update(Teacher teacher) {
        int affectedRows = teacherMapper.update(teacher);
        return affectedRows > 0;
    }

    @Override
    public boolean delete(Long id) {
        int affectedRows = teacherMapper.delete(id);
        return affectedRows > 0;
    }
}
