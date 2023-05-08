package com.microdream.databaseonlinecoursespringbackend.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author Hanasaki_Fubuki
 */
@Component("fileInfo")
@Getter
@Setter
@TableName("file_info")
public class FileInfo {

private int id;
    private String filename;
    private String path;
    private String url;
    private long size;

}
