package com.microdream.databaseonlinecoursespringbackend.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hanasaki_Fubuki
 */

@Component("filePojo")
@Getter
@Setter
public class FilePojo {

    private String filename;
    private MultipartFile files;
    private String path;

}
