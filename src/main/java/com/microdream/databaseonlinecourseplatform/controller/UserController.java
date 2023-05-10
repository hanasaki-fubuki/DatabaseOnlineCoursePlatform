package com.microdream.databaseonlinecourseplatform.controller;

import com.microdream.databaseonlinecourseplatform.pojo.User;
import com.microdream.databaseonlinecourseplatform.pojo.response.ChangePasswordRequest;
import com.microdream.databaseonlinecourseplatform.service.SystemLogService;
import com.microdream.databaseonlinecourseplatform.service.UserService;
import com.microdream.databaseonlinecourseplatform.pojo.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
                systemLogService.userSignInFailed(userService.getUidByUsername(username), userService.getRoleByUsername(username));
            }
            log.info("User login failed: " + username);
            return new Result(400);
        } else {
            systemLogService.userSignInSuccess(successUser.getId(), successUser.getRole());
            log.info("User login successfully: " + username);
            return new Result(200, successUser);
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

    /**
     * 用户修改密码接口
     * @param request 尝试修改密码的用户和新密码
     * @return 修改成功返回200，修改失败返回400
     */
    @CrossOrigin
    @PostMapping(value = "/change-pass")
    @ResponseBody
    public Result changePass(@RequestBody ChangePasswordRequest request) {
        if (userService.changePass(request.getUser(), request.getOriPassword(), request.getNewPassword())) {
            systemLogService.userPassChangedSuccess(request.getUser().getId(), request.getUser().getRole());
            log.info("User changed password successfully: " + request.getUser().getUsername());
            return new Result(200);
        } else {
            systemLogService.userPassChangedFailed(request.getUser().getId(), request.getUser().getRole());
            log.info("User failed to change password: " + request.getUser().getUsername());
            return new Result(400);
        }

    }

}
