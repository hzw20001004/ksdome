package com.ks.Controller;
import com.ks.Server.DBSrever;
import com.ks.common.Utils.Base.BaseController;
import com.ks.common.pojo.DataSource1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DB")
public class DBController extends BaseController<DBSrever, DataSource1> {

}