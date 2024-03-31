package org.zz.demo1.service;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.zz.demo1.domain.entity.Student;
import org.zz.demo1.mapper.StudentMapper;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll(Integer p, Integer pn) {
        if (p != null && pn != null) {
            PageHelper.startPage(p, pn);
        }

        PageHelper.orderBy("id desc");
        return studentMapper.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentMapper.findById(id);
    }

    @Override
    public Student findByName(String name) {
        return studentMapper.findByName(name);
    }

    @Override
    public boolean batchSave(List<Student> students) {
        int affectedRows = studentMapper.batchSave(students);
        return affectedRows > 0;
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
