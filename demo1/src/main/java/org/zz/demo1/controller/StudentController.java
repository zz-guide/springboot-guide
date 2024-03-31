package org.zz.demo1.controller;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.zz.demo1.common.ResponseResult;
import org.zz.demo1.domain.entity.Student;
import org.zz.demo1.domain.request.*;
import org.zz.demo1.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/search")
    public ResponseResult<?> search(@Valid StudentSearchRequest params) {
        var students = studentService.findAll(params.getP(), params.getPn());
        if (students == null || students.isEmpty()) {
            return ResponseResult.success();
        }

        log.info("student detail success");
        return ResponseResult.success(new PageInfo <Student>(students));
    }

    @GetMapping("/detail")
    public ResponseResult<?> detail(@Valid StudentDetailRequest params) {
        var student = studentService.findById(params.getId());
        if (student == null) {
            return ResponseResult.fail("学生不存在");
        }

        log.info("student detail success");
        return ResponseResult.success(student);
    }

    @PostMapping("/create")
    public ResponseResult<?> create(@Validated @RequestBody StudentCreateRequest params) {
        if (studentService.findByName(params.getName()) != null) {
            return ResponseResult.fail("学生姓名已存在，请更换");
        }

        var student = Student.builder().name(params.getName()).age(params.getAge()).build();
        if (!studentService.save(student)) {
            return ResponseResult.fail("创建学生失败，请重试");
        }

        log.info("student create success");
        return ResponseResult.success();
    }

    @PostMapping("/update")
    public ResponseResult<?> update(@Validated @RequestBody StudentUpdateRequest params) {
        var student = studentService.findById(params.getId());
        if (student == null) {
            return ResponseResult.fail("学生不存在");
        }

        if (StringUtils.isBlank(params.getName())) {
            student.setName(params.getName());
        }

        if (params.getAge() > 0) {
            student.setAge(params.getAge());
        }

        if (!studentService.update(student)) {
            return ResponseResult.fail("更新学生失败，请重试");
        }

        log.info("student update success");
        return ResponseResult.success();
    }

    @PostMapping("/delete")
    public ResponseResult<?> delete(@Validated @RequestBody StudentDeleteRequest params) {
        var student = studentService.findById(params.getId());
        if (student == null) {
            return ResponseResult.fail("学生不存在");
        }

        if (!studentService.delete(params.getId())) {
            return ResponseResult.fail("删除学生失败，请重试");
        }

        log.info("student delete success");
        return ResponseResult.success();
    }
}
