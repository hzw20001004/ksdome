package com.Ks.Controller;

import com.Ks.Base.BaseController;
import com.Ks.Pojo.SysUser;

import com.Ks.Service.UserSrever;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<UserSrever, SysUser> {

}
