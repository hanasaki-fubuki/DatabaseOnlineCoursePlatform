package com.microdream.databaseonlinecourseplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.microdream.databaseonlinecourseplatform.pojo.FilePojo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Hanasaki_Fubuki
 */
public interface FilePojoService extends IService<FilePojo> {

    /**
     * 文件上传函数
     * @param file 需要上传的文件
     * @return 是否上传成功
     */
    boolean upload(MultipartFile file);


    /**
     * 在数据库中添加文件信息
     * @param file 上传的文件
     * @param listNum 文件所属的课程号
     * @param url 文件的url
     * @return 是否添加成功
     */
    boolean insertFilePojo(MultipartFile file, int listNum, String url);

    /**
     * 根据课程号查找文件
     * @param listNum 课程号
     * @return 该课程号下的所有文件
     */
    List<FilePojo> findByListNum(int listNum);



}
