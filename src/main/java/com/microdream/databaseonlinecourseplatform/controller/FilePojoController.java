package com.microdream.databaseonlinecourseplatform.controller;

import com.microdream.databaseonlinecourseplatform.pojo.FilePojo;
import com.microdream.databaseonlinecourseplatform.pojo.response.Result;
import com.microdream.databaseonlinecourseplatform.service.FilePojoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hanasaki_Fubuki
 */
@RestController
@Slf4j
public class FilePojoController {

    @Resource
    FilePojoService filePojoService;

    @CrossOrigin
    @RequestMapping(value = "/file-upload", method = RequestMethod.POST)
    public Result fileUpload(@RequestParam("files") MultipartFile file, @RequestParam int listNum) {
        if (filePojoService.upload(file) && filePojoService.insertFilePojo(file, listNum, "http://localhost:8080/file/" + file.getOriginalFilename())) {
            log.info("已上传文件：课程章节 " + listNum + "，文件名：" + file.getOriginalFilename());
            return new Result(200);
        } else {
            return new Result(500);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/file-list", method = RequestMethod.POST)
    public List<FilePojo> showFileList(@RequestBody FilePojo filePojo) {
        int listNum = filePojo.getListNum();
        log.info("正在获取文件列表：课程章节 " + listNum);
        return filePojoService.findByListNum(listNum);
    }

    @CrossOrigin
    @RequestMapping(value = "/file-delete", method = RequestMethod.POST)
    public Result deleteFile(@RequestParam("id") int id) {
        if (filePojoService.removeById(id)) {
            log.info("已删除文件：id" + id);
            return new Result(200);
        } else {
            return new Result(500);
        }
    }

}
