package com.ks.Controller;

import com.ks.Base.BaseController;
import com.ks.Pojo.SysUser;

import com.ks.Service.UserSrever;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<UserSrever, SysUser> {

}
