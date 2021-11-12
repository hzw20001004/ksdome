package com.ks.CSD.Controller;

import com.ks.CSD.Service.UserSrever;
import com.ks.GJ.Test.BaseController;
import com.ks.GJ.Test.Bases;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<UserSrever, Bases> {
}
