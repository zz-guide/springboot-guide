package org.zz.demo1.service;

import org.zz.demo1.domain.entity.Teacher;

import java.util.List;

public interface TeacherService {
    public List<Teacher> findAll();

    public Teacher findById(Long id);

    public boolean save(Teacher teacher);

    public boolean update(Teacher teacher);

    public boolean delete(Long id);

    public Teacher findByName(String name);
}