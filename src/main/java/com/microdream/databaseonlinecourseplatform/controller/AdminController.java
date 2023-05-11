package com.microdream.databaseonlinecourseplatform.controller;

import com.microdream.databaseonlinecourseplatform.pojo.SystemLog;
import com.microdream.databaseonlinecourseplatform.pojo.User;
import com.microdream.databaseonlinecourseplatform.pojo.response.Result;
import com.microdream.databaseonlinecourseplatform.service.SystemLogService;
import com.microdream.databaseonlinecourseplatform.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hanasaki_Fubuki
 */
@Controller
@Slf4j
public class AdminController {

    @Resource
    UserService userService;

    @Resource
    SystemLogService systemLogService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/user-table", method = RequestMethod.POST)
    public List<User> getUserTable() {
        return userService.list();
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/system-log", method = RequestMethod.POST)
    public List<SystemLog> getFullLog() {
        return systemLogService.lambdaQuery().orderByDesc(SystemLog::getLogTime).list();
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/user-elevation", method = RequestMethod.POST)
    public Result userElevation(@RequestBody User user) {
        if (userService.updateById(user)) {
            systemLogService.userElevationSuccess(user.getId());
            return new Result(200);
        } else {
            return new Result(400);
        }
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/user-delevation", method = RequestMethod.POST)
    public Result userDelevation(@RequestBody User user) {
        if (userService.updateById(user)) {
            systemLogService.userDelevationSuccess(user.getId());
            return new Result(200);
        } else {
            return new Result(400);
        }
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/remove-user", method = RequestMethod.POST)
    public Result removeUser(@RequestBody User user) {
        if (userService.removeById(user.getId())) {
            systemLogService.userRemoveSuccess(user.getId());
            return new Result(200);
        } else {
            return new Result(400);
        }
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/remove-log", method = RequestMethod.POST)
    public Result removeLog(@RequestBody SystemLog systemLog) {
        if (systemLogService.removeById(systemLog.getId())) {
            return new Result(200);
        } else {
            return new Result(400);
        }
    }

}
