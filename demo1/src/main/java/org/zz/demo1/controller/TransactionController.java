package org.zz.demo1.controller;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zz.demo1.common.ResponseResult;
import org.zz.demo1.domain.entity.Student;
import org.zz.demo1.domain.entity.Teacher;
import org.zz.demo1.exception.MyException;
import org.zz.demo1.service.StudentService;
import org.zz.demo1.service.TeacherService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TeacherService teacherService;
    private final StudentService studentService;

    @Resource
    TransactionTemplate transactionTemplate;

    Logger log = LoggerFactory.getLogger(this.getClass());

    public TransactionController(TeacherService teacherService,StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @PostMapping("/auto")
    public ResponseResult<?> auto() {
        try {
            autoTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("事务执行成功");
        return ResponseResult.success();
    }

    /**
     * 1. 默认的回滚异常是运行时异常RuntimeException，其他异常不会回滚
     * 2. 通过@Transactional(rollbackFor = Exception.class) 指定碰见异常就回滚
     */
    @Transactional(rollbackFor = Exception.class)
    public void testTransaction() throws MyException {
        studentService.save(Student.builder().name("仔仔1").age(25).build());
        teacherService.save(Teacher.builder().name("仔仔老师1").age(25).build());
        throw new MyException();
    }

    public void autoTransaction() throws MyException {
        testTransaction();
    }

    /**
     * 1. 通过 transactionTemplate 自定义事务管理
     * 2. setIsolationLevel 设置隔离级别
     * 3. setPropagationBehavior 设置事务传播
     */
    @PostMapping("/manual")
    public ResponseResult<?> manual() {

        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        String res = transactionTemplate.execute((TransactionCallback<String>) status -> {
            try {
                studentService.save(Student.builder().name("仔仔1").age(25).build());
                teacherService.save(Teacher.builder().name("仔仔老师1").age(25).build());
                throw new RuntimeException("主动异常");
//                return "事务执行成功";
            } catch (Exception e) {
                System.out.println("事务抛出异常:" + e);
                status.setRollbackOnly();
                throw e;
            }
        });
        System.out.println("res:" + res);
        return ResponseResult.success();
    }
}
