package it.chen;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 工具类
 * 密码加密
 * 这个类由spring security 提供
 */
public class BCryptPasswordEncoderUtil {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    //传入一个密码
    public static String passwordEncoder(String password){
        return bCryptPasswordEncoder.encode(password);
    }

//    public static void main(String[] args) {
//        String chen = passwordEncoder("chen");
//        System.out.println(chen);
//    //$2a$10$P43M/RRiIbEC8UcnAdqkyOvtP0ZQEU/rUv/6oQXDZQSrEsCOIeeaC
//    }
}
