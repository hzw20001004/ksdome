package com.ks.Controller;

import com.ks.common.Utils.RedisUtils;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RedisUtils redisUtils;
    /**
     * 获取用户资源信息
     * @param authentication
     * @return
     */
    @RequestMapping("/getuser")
    public  Object getuser(Authentication authentication){
        return authentication;
    }
    @RequestMapping("/getuser1")
    public  Object getuser1(Authentication authentication){
        return redisUtils.deleteObject("han");
    }
}
