package com.Ks.Controller;
import com.Ks.Server.UserSrever;
import com.Ks.common.Utils.Base.BaseController;
import com.Ks.pojo.System.SysUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserSrever, SysUser> {
//    /**
//     * 获取用户资源信息
//     * @param authentication
//     * @return
//     */
//    @RequestMapping("/getuser")
//    public  Object getuser(Authentication authentication, HttpServletRequest request){
//        String authorization = request.getHeader("Authorization");
//        String bearer = authorization.substring(authorization.indexOf("Bearer") + 7);
//        return Jwts.parser()
//                .setSigningKey("xxxx".getBytes(StandardCharsets.UTF_8))
//                .parseClaimsJws(bearer)
//                .getBody();
//    }



//    @RequestMapping("/getuser1")
//    public  Object getuser1(){
//        return redisUtils.deleteObject("han");
//    }
}
