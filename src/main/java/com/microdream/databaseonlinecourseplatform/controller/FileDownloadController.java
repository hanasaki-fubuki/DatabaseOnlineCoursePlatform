package com.microdream.databaseonlinecourseplatform.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * @author Hanasaki_Fubuki
 */
@Controller
@Slf4j
@RequestMapping("/file")
public class FileDownloadController {

    @CrossOrigin
    @GetMapping("/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) throws IOException {
        // 获取文件
        File file = new File("D:/dboc_files/" + filename);

        // 创建输入流
        InputStream inputStream = new FileInputStream(file);

        // 创建资源对象
        Resource resource = new InputStreamResource(inputStream);

        // 获取文件的MIME类型
        String mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;

        if (filename.endsWith(".ppt") || filename.endsWith(".pptx")) {
            mimeType = "application/vnd.ms-powerpoint";
        } else if (filename.endsWith(".avi")) {
            mimeType = "video/x-msvideo";
        }

        // 创建响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.parseMediaType(mimeType));

        // 创建响应实体对象

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

}
