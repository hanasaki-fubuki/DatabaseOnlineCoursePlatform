package com.microdream.databaseonlinecourseplatform.pojo.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Hanasaki_Fubuki
 */
@Getter
@Setter
public class Result {
    private int code;
    private String message;
    private Object obj;

    public Result(Integer code) {
        this.code = code;
    }

    public Result(int code, Object obj) {
        this.code = code;
        this.obj = obj;
    }

    public Result(int code, String message, Object obj) {
        this.code = code;
        this.message = message;
        this.obj = obj;
    }
}