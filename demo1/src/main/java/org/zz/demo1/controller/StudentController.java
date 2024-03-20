package org.zz.demo1.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.zz.demo1.common.ResponseResult;
import org.zz.demo1.domain.entity.Student;
import org.zz.demo1.domain.request.student.StudentCreate;
import org.zz.demo1.domain.request.student.StudentDetail;
import org.zz.demo1.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/detail")
    public ResponseResult<?> detail(@Valid StudentDetail params) {
        Student student = studentService.findById(params.getId());
        if (student == null) {
            return ResponseResult.fail("查询失败，请重试");
        }

        log.info("asldkjhlasjdlkjasdlk");
        return ResponseResult.success(student);
    }

    @PostMapping("/create")
    public ResponseResult<?> create(@Validated @RequestBody StudentCreate params) {
        Student student = new Student();
        student.setName(params.getName());
        student.setAge(params.getAge());
        if (!studentService.save(student)) {
            return ResponseResult.fail("学生创建失败，请重试");
        }

        return ResponseResult.success();
    }
}
