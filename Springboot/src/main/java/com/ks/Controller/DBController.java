package com.ks.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DB")
public class DBController {
//    @Resource
//    private UserSrever userSrever;
//    @Resource
//    private DBSrever dbSrever;
//
//    @GetMapping("/test")
//    @ResponseBody
//    public Dto DB() {
//        try {
////切换到数据库dbtest2
//            String datasourceId="dbtest2";
//            dbSrever.changeDb("ks");
//            List<User> userList= userSrever.findByCondition();
//            System.out.println(userList.toString());
//
//            //再切换到数据库dbtest3
//            dbSrever.changeDb("test");
//            List<User> userList3= userSrever.findByCondition();
//            System.out.println(userList3.toString());
//            //切回主数据源
//            //DBContextHolder.clearDataSource();
//            return Dto.OK;
//        } catch (Exception e) {
//            Dto.error("系统异常");
//        }
//        return Dto.OK;
//    }
}