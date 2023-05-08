package com.microdream.databaseonlinecoursespringbackend.controller;

import com.microdream.databaseonlinecoursespringbackend.pojo.User;
import com.microdream.databaseonlinecoursespringbackend.response.Result;
import com.microdream.databaseonlinecoursespringbackend.service.SystemLogService;
import com.microdream.databaseonlinecoursespringbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Hanasaki_Fubuki
 */
@Controller
@ResponseBody
@Slf4j
public class UserController {
    @Resource
    UserService userService;
    @Resource
    SystemLogService systemLogService;

    /**
     * 用户登录接口
     * @param requestUser 请求登录的用户
     * @return 登录成功返回200，登录失败返回400
     */
    @CrossOrigin
    @PostMapping(value = "/sign-in")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        User successUser = userService.signIn(requestUser);

        if (null == successUser) {
            // 下面的if用来判断尝试登录的用户是否存在，如果存在则记录失败登录尝试日志，否则不记录
            if (userService.getUidByUsername(username) != -1) {
                systemLogService.userSignInFailed(userService.getUidByUsername(username));
            }
            log.info("User login failed: " + username);
            return new Result(400);
        } else {
            systemLogService.userSignInSuccess(successUser.getId());
            log.info("User login successfully: " + username);
            return new Result(200);
        }
    }

    /**
     * 用户注册接口
     * @param signUpUser 尝试注册的用户
     * @return 注册成功返回200，用户名重复返回100
     */
    @CrossOrigin
    @PostMapping(value = "/sign-up")
    @ResponseBody
    public Result signUp(@RequestBody User signUpUser) {
        signUpUser.setRole(2);
        int result = userService.signUp(signUpUser);
        if (result == 1) {
            log.info("User sign up failed: " + signUpUser.getUsername());
            systemLogService.usernameDuplicate(userService.getUidByUsername(signUpUser.getUsername()));
            return new Result(100);
        } else {
            systemLogService.userSignUpSuccess(userService.getUidByUsername(signUpUser.getUsername()));
            log.info("User sign up successfully: " + signUpUser.getUsername());
            return new Result(200);
        }

    }

}
