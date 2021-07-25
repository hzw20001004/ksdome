package com.ks.Controller;
import com.ks.Server.UserSrever;
import com.ks.common.Utils.Base.BaseController;
import com.ks.common.Utils.Base.Dto;
import com.ks.common.pojo.System.SysUser;
import com.ks.common.pojo.System.User;
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
public class UserController extends BaseController<UserSrever, SysUser> {
}
