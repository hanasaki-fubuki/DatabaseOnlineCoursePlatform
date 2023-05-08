package com.microdream.databaseonlinecoursespringbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.microdream.databaseonlinecoursespringbackend.pojo.FilePojo;

/**
 * @author Hanasaki_Fubuki
 */
public interface FilePojoService extends IService<FilePojo> {

    /**
     * 文件上传函数
     * @param filePojo 需要上传的文件
     * @param path 文件上传路径
     */
    void upload(FilePojo filePojo, String path);

}
