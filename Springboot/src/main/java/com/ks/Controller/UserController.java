package com.ks.Controller;
import com.ks.Server.UserSrever;

import com.ks.common.Base.BaseController;
import com.ks.common.Utils.RedisUtils;
import com.ks.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
