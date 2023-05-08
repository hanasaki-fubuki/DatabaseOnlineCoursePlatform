package com.microdream.databaseonlinecoursespringbackend;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

/**
 * <p>
 * 密码生成相关（可以初始化用户登录密码及配置文件配置密码）
 * </p>
 *
 * @author Star Walker
 * @date 2019/12/26
 */
public class PasswordGenerate {

    public static void main(String[] args) {
        //解密数据库密码
//        decrypt("7lz8d67XoTOtYZNZi+ta7zzUscx1/Z2R");
        //加密数据库密码
        encrypt("Password01");
    }

    /**
     * 将配置文件的密码加密
     *
     * @param password 密码
     * @date 2019/12/26
     */
    private static void encrypt(String password) {
        //加密工具
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        //加密配置
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        //自己在用的时候更改此密码
        config.setPassword("microdream_encryption");
        //应用配置
        encryptor.setConfig(config);
        //加密
        String ciphertext = encryptor.encrypt(password);
        System.out.println(password + " : " + ciphertext);
    }


    /**
     * 解密
     *
     * @param password 密文
     * @date 2019/12/26
     */
    private static void decrypt(String password) {
        //加密工具
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        //加密配置
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        //自己在用的时候更改此密码
        config.setPassword("microdream_encryption");
        //应用配置
        encryptor.setConfig(config);
        //加密
        String ciphertext = encryptor.decrypt(password);
        System.out.println(password + " : " + ciphertext);
    }
}
