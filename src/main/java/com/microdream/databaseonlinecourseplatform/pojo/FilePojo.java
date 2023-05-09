package com.microdream.databaseonlinecourseplatform.pojo;

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
public class FilePojo {

    private int id;

    private String filename;
    private int listNum;
    private String url;

}
