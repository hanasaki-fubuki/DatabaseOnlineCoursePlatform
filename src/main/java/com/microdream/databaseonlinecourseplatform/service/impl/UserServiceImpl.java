package com.microdream.databaseonlinecourseplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microdream.databaseonlinecourseplatform.pojo.User;
import com.microdream.databaseonlinecourseplatform.mapper.UserMapper;
import com.microdream.databaseonlinecourseplatform.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Hanasaki_Fubuki
 */
@Service
@Resource
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Value("${jasypt.encryptor.password}")
    String encPass;
    @Value("${jasypt.encryptor.algorithm}")
    String encAlgo;
    @Override
    public int getUidByUsername(String username) {
        QueryWrapper<User> getUidByUsernameQueryWrapper = new QueryWrapper<>();
        getUidByUsernameQueryWrapper.eq("username", username);
        User user = getOne(getUidByUsernameQueryWrapper);
        if (user != null) {
            return user.getId();
        } else {
            return -1;
        }
    }

    @Override
    public int getRoleByUsername(String username) {
        QueryWrapper<User> getRoleByUsernameQueryWrapper = new QueryWrapper<>();
        getRoleByUsernameQueryWrapper.eq("username", username);
        User user = getOne(getRoleByUsernameQueryWrapper);
        if (user != null) {
            return user.getRole();
        } else {
            return -1;
        }
    }

    @Override
    public User signIn(User user) {
        QueryWrapper<User> signInQueryWrapper = new QueryWrapper<>();
        signInQueryWrapper.eq("username", user.getUsername());
        User targetUser = getOne(signInQueryWrapper);
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm(encAlgo);
        config.setPassword(encPass);
        encryptor.setConfig(config);
        if (targetUser != null) {
            if (encryptor.decrypt(targetUser.getPassword()).equals(user.getPassword())) {
                return targetUser;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public int signUp(User user) {
        QueryWrapper<User> signUpQueryWrapper = new QueryWrapper<>();
        signUpQueryWrapper.eq("username", user.getUsername());
        User targetUser = getOne(signUpQueryWrapper);
        if (targetUser != null) {
            return 1;
        } else {
            StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
            EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
            config.setAlgorithm(encAlgo);
            config.setPassword(encPass);
            encryptor.setConfig(config);
            user.setPassword(encryptor.encrypt(user.getPassword()));
            save(user);
            return 0;
        }

    }

    @Override
    public boolean changePass(User user, String oriPassword, String newPassword) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm(encAlgo);
        config.setPassword(encPass);
        encryptor.setConfig(config);
        QueryWrapper<User> changePasswordQueryWrapper = new QueryWrapper<>();
        changePasswordQueryWrapper.eq("username", user.getUsername());
        User targetUser = getOne(changePasswordQueryWrapper);
        if (targetUser != null) {
            if (encryptor.decrypt(targetUser.getPassword()).equals(oriPassword)) {
                targetUser.setPassword(encryptor.encrypt(newPassword));
                updateById(targetUser);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
