package com.xkcoding.actuator;

import com.ks.dao.Userdao;
import com.ks.pojo.User;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class Usertest extends SpringBootDemoActuatorApplicationTests{
    @Resource
    public Userdao userdao;
    @Test
    public void contextLoads() {
        List<User> users = userdao.selectList(null);
        users.stream().forEach(user -> {
            System.out.println(user);
        });
    }
}
