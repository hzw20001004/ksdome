package com.ks.Controller;
import com.ks.Server.UserSrever;
import com.ks.common.Base.BaseController;
import com.ks.common.Base.Dto;
import com.ks.common.pojo.User;
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
    @GetMapping("/li")
    @ResponseBody
    public Dto findByCondition1() {
        try {
            return Dto.OKdata(baseMapper.findByCondition(),"查询成功");
        } catch (Exception e) {
            return Dto.errorsystem("系统异常");
        }
    }
}
