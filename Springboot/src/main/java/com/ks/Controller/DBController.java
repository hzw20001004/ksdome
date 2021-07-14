package com.ks.Controller;
import com.ks.Server.DBSrever;
import com.ks.Server.UserSrever;
import com.ks.common.Base.BaseController;
import com.ks.pojo.DataSource1;
import com.ks.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DB")
public class DBController extends BaseController<DBSrever, DataSource1> {

}