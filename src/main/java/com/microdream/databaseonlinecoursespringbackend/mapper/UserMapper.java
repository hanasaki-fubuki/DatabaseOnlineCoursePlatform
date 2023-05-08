package com.microdream.databaseonlinecoursespringbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.microdream.databaseonlinecoursespringbackend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Hanasaki_Fubuki
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
