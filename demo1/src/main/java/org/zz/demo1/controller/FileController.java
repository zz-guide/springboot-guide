package org.zz.demo1.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zz.demo1.common.ResponseResult;
import org.zz.demo1.config.ApplicationConfig;
import org.zz.demo1.domain.request.FileUploadRo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    @Resource
    ApplicationConfig applicationConfig;

    @PostMapping("/upload")
    public ResponseResult<?> upload(@Validated FileUploadRo fileUploadRo) {
        String contextPath = applicationConfig.getContextPath();
        if (contextPath != null && contextPath.startsWith("/")) {
            contextPath = contextPath.substring(1);
        }

        System.out.println("contextPath:" + contextPath);
        MultipartFile file = fileUploadRo.getFile();
        if (file == null || file.isEmpty()) {
            return ResponseResult.fail("上传文件不能为空");
        }

        String name = file.getName();
        String originalFilename = file.getOriginalFilename();
        String contentType = file.getContentType();
        // 本地磁盘的文件名称，不带路径
        System.out.println("name:" + name);
        System.out.println("getOriginalFilename:" + originalFilename);
        System.out.println("contentType:" + contentType);

        if (originalFilename == null || originalFilename.isBlank()) {
            return ResponseResult.fail("文件名称不能为空");
        }

        String fileExt = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        System.out.println("fileExt:" + fileExt);

        // 这种带classpath的都是target木目录下的路径
        // 先获取classpath 路径，然后拼接判断
        File targetFile = null;
        try {
            // 切记不要少了冒号
            String resourcesPath = ResourceUtils.getURL("classpath:").getPath();
            // resourcesPath:/E:/jungle/github/zz-guide/springboot-guide/demo1/target/classes/
            // 注意到最前边的斜杠了吗？
            System.out.println("resourcesPath:" + resourcesPath);
            targetFile = new File(resourcesPath);
            // targetPath:E:\jungle\github\zz-guide\springboot-guide\demo1\target\classes
            // 注意到分隔符根据平台做了转换
            System.out.println("targetFile:" + targetFile);
        } catch (FileNotFoundException e) {
            return ResponseResult.fail("classpath 不存在");
        }

        File uploadsFile = new File(String.format("%s%s", targetFile.getAbsolutePath(), applicationConfig.getUploads()));
        // 默认空目录不会拷贝到target目录下
        if (!uploadsFile.exists()) {
            boolean res = uploadsFile.mkdirs();
            if (!res) {
                return ResponseResult.fail("uploads目录创建失败");
            }
        }

        // 构建新的文件名称
        String newFilename = new Date().getTime() + "." + fileExt;
        String dbFilePath = applicationConfig.getUploads().substring(1) + newFilename;
        File dest = new File(uploadsFile.getAbsolutePath() + "/" + newFilename);
        String localFilePath = null;
        try {
            // 先保存到target目录下
            file.transferTo(dest);
            // 项目真实路径下的uploads目录
            File readFile = new File(String.format("%s/%s%s%s%s", System.getProperty("user.dir"), contextPath, "/src/main/resources" , applicationConfig.getUploads(), newFilename));
            localFilePath = String.format("%s:%s/%s/%s", applicationConfig.getAddress(), applicationConfig.getPort(), contextPath, dbFilePath);
            System.out.println("readFile:" + readFile.getAbsolutePath());
            FileCopyUtils.copy(dest, readFile);
        } catch (Exception e) {
            return ResponseResult.fail(e);
        }

        Map<String, Object> res = new HashMap<>();
        res.put("db_file_path", dbFilePath);
        res.put("local_file_path", localFilePath);
        return ResponseResult.success(res);
    }
}
