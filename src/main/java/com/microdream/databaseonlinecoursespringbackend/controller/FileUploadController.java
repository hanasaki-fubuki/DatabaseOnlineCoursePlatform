package com.microdream.databaseonlinecoursespringbackend.controller;

import com.microdream.databaseonlinecoursespringbackend.pojo.FilePojo;
import com.microdream.databaseonlinecoursespringbackend.response.Result;
import com.microdream.databaseonlinecoursespringbackend.service.FilePojoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hanasaki_Fubuki
 */
@RestController
@Slf4j
public class FileUploadController {

    @Resource
    FilePojoService filePojoService;

    @CrossOrigin
    @GetMapping("/file-list")
    public List<FilePojo> getFilePojoList(@RequestParam("path") String path) {
        List<FilePojo> filePojoList = new ArrayList<>();
        File fileDir = new File("D:/dboc_files/" + path + "/");
        if (fileDir.exists() && fileDir.isDirectory()) {
            File[] files = fileDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    FilePojo filePojo = new FilePojo();
                    filePojo.setFilename(filePojo.getFilename());
                    filePojo.setPath(filePojo.getPath());
                    filePojoList.add(filePojo);
                }
            }
        }
        return filePojoList;
    }

    @CrossOrigin
    @RequestMapping(value = "/file-upload", method = RequestMethod.POST)
    public Result fileUpload(@RequestParam("files") MultipartFile file, @RequestParam("path") String path) throws Exception {
        String fileName = file.getOriginalFilename();

        // 此处替换要上传的文件地址
        String paths = "D:/dboc_files/" + path + "/";
        // 此处路径地址需要转义，/改为//，文件名称相同，前一个文件会被替换掉。
        FilePojo f = new FilePojo();
        f.setFilename(fileName);
        f.setFiles(file);

        // 上传文件
        filePojoService.upload(f, paths);
        return new Result(200);

        //n返回页面相应数据
//        Map<String, Object> resultMap= new HashMap<>();
//        resultMap.put("uuid", uuid);
//        resultMap.put("name", name);
//        return ResultUtils.ok().put("resultMap", resultMap);
    }

}
