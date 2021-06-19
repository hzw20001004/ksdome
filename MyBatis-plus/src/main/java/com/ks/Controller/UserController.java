package com.ks.Controller;
import com.ks.Server.UserSrever;
import com.ks.common.BaseController;
import com.ks.common.BaseService;
import com.ks.common.Dto;
import com.ks.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
public class UserController extends BaseController<UserSrever, User> {
    public Dto add(User user) {
        return baseMapper.add(user);
    }

    public Dto update(User user) {
        return baseMapper.update(user);
    }

    public Dto delete(List<Integer> ids) {
        return baseMapper.delete(ids);
    }

    public Dto findByCondition() {
        return baseMapper.findByCondition();
    }

    public Dto findById(Integer id) {
        return baseMapper.findById(id);
    }
}
