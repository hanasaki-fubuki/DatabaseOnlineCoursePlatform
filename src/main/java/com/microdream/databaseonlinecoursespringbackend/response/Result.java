package com.microdream.databaseonlinecoursespringbackend.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Hanasaki_Fubuki
 */
@Getter
@Setter
public class Result {
    private int code;

    public Result(Integer code) {
        this.code = code;
    }
}