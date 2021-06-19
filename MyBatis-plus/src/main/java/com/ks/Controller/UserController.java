package com.ks.Controller;
import com.ks.Server.UserSrever;
import com.ks.common.BaseController;
import com.ks.common.BaseService;
import com.ks.common.Dto;
import com.ks.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright (C), 2021-2021
 * FileName: UserController
 * Author:   50857
 * Date:     2021/6/10 20:27
 * Description: 用户
 */
@RestController
@RequestMapping("/test")
public class UserController extends BaseController<UserSrever,User> {
}
