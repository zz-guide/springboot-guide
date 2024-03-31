package org.zz.demo1;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;
import org.zz.demo1.domain.entity.Student;
import org.zz.demo1.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class Demo1PageHelperTests {
    @Resource
    StudentService studentService;

    @Test
    void testPageHelper() {

    }


    @Test
    void testBatchInsert() {
        Random random = new Random();

        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 60000; i++) {
            Student student = new Student();
            student.setName("仔仔" + (i+1));
            int randomAge = random.nextInt(125) + 1;
            student.setAge(randomAge);
            studentList.add(student);
        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("批量插入");
        boolean res = studentService.batchSave(studentList);
        if (res) {
            System.out.println("批量插入成功");
        } else {
            System.out.println("批量插入失败");
        }

        stopWatch.stop();

        StopWatch.TaskInfo taskInfo = stopWatch.lastTaskInfo();
        String lastTaskName = taskInfo.getTaskName();
        System.out.println(lastTaskName + ":" + stopWatch.getTotalTimeMillis());
    }
}