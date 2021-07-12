package com.ks.Controller;
import com.ks.Server.UserSrever;

import com.ks.common.Base.BaseController;
import com.ks.common.Base.Dto;
import com.ks.common.Utils.RedisUtils;
import com.ks.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.logging.Handler;

/**
 * Copyright (C), 2021-2021
 * FileName: UserController
 * Author:   HZW
 * Date:     2021/6/10 20:27
 * Description: 用户
 */
@RestController
@RequestMapping("/test")
public class UserController extends BaseController<UserSrever,User> {
    @Autowired
    public RedisUtils redisUtils;
    @GetMapping("/redis")
    @ResponseBody
    public Dto redis() {
        Object han = null;
        try {
            redisUtils.set("han1", "jiayou", 60 * 2);
            han = redisUtils.get("han1");
            return Dto.OK;
        } catch (Exception e) {
            Dto.error("系统异常");
        }
        return Dto.OKmag(han,"成功");
    }
}
