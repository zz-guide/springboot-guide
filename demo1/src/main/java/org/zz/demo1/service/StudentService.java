package org.zz.demo1.service;

import org.zz.demo1.domain.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll(Integer p, Integer pn);

    public Student findById(Long id);

    public boolean save(Student student);

    public boolean update(Student student);

    public boolean delete(Long id);

    public Student findByName(String name);

    public boolean batchSave(List<Student> students);
}