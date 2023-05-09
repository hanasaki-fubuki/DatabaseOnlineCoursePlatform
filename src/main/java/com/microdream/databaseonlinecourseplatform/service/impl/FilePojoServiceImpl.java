package com.microdream.databaseonlinecourseplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microdream.databaseonlinecourseplatform.mapper.FilePojoMapper;
import com.microdream.databaseonlinecourseplatform.pojo.FilePojo;
import com.microdream.databaseonlinecourseplatform.service.FilePojoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hanasaki_Fubuki
 */
@Service
@Resource
@Slf4j
public class FilePojoServiceImpl extends ServiceImpl<FilePojoMapper, FilePojo> implements FilePojoService {

    @Override
    public boolean upload(MultipartFile file) {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 文件上传地址
        String paths = "D:/dboc_files/";
        // 将文件保存到本地
        try {
            // 创建文件
            java.io.File file1 = new java.io.File(paths + fileName);
            // 将文件写入目标
            file.transferTo(file1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean insertFilePojo(MultipartFile file, int listNum, String url) {
        FilePojo filePojo = new FilePojo();
        filePojo.setListNum(listNum);
        filePojo.setUrl(url);
        filePojo.setFilename(file.getOriginalFilename());
        return save(filePojo);
    }

    @Override
    public List<FilePojo> findByListNum(int listNum) {
        QueryWrapper<FilePojo> qw = new QueryWrapper<>();
        qw.eq("list_num", listNum);
        return list(qw);
    }
}
