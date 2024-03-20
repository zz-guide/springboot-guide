package org.zz.demo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zz.demo1.domain.entity.Student;
import org.zz.demo1.mapper.StudentMapper;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(Long id) {
        return studentMapper.findById(id);
    }

    @Override
    public boolean save(Student student) {
        int affectedRows = studentMapper.save(student);
        return affectedRows > 0;
    }

    @Override
    public boolean update(Student student) {
        int affectedRows = studentMapper.update(student);
        return affectedRows > 0;
    }

    @Override
    public boolean delete(Long id) {
        int affectedRows = studentMapper.delete(id);
        return affectedRows > 0;
    }
}
