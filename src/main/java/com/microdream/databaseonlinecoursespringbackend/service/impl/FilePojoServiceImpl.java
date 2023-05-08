package com.microdream.databaseonlinecoursespringbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microdream.databaseonlinecoursespringbackend.mapper.FilePojoMapper;
import com.microdream.databaseonlinecoursespringbackend.pojo.FilePojo;
import com.microdream.databaseonlinecoursespringbackend.service.FilePojoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Hanasaki_Fubuki
 */
@Service
@Resource
public class FilePojoServiceImpl extends ServiceImpl<FilePojoMapper, FilePojo> implements FilePojoService {
    @Override
    public void upload(FilePojo filePojo, String path) {
        try {
            java.io.File file1 = new java.io.File(path + filePojo.getFilename());
            filePojo.getFiles().transferTo(file1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
