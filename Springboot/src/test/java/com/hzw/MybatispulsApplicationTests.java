//package com.hzw;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.impl.Base64Codec;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import javax.annotation.Resource;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@SpringBootTest
//class ApplicationTestsTest {
////密码 测试
////    @Test
////    void TestPW() {
////        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
////        //生成盐
////        String qpalzm13579 = bc.encode("qpalzm13579");
////        System.out.println(qpalzm13579);
////        //拿盐和用户输入的密码来判断是否登录   可以不用存储用户密码
////        boolean qpalzm135791 = bc.matches("qpalzm1357", qpalzm13579);
////        System.out.println(qpalzm135791);
////
////
////    }
//
//    /**
//     * JWT生成token
//     */
//     @Test
//   public   String  testJwt(){
//         //获取当前时间戳
//         long now = System.currentTimeMillis();
//         //30秒过期
//         long exp = now + 30 * 1000;
//         JwtBuilder jwtBuilder = Jwts.builder()
//                 //id
//                 .setId("222")
//                 //签发用户
//                 .setSubject("admin")
//                 //签发时间
//                 .setIssuedAt(new Date())
//                 //过期时间
//                 .setExpiration(new Date(exp))
//                 .signWith(SignatureAlgorithm.HS256, "xxxxxx");
//         String token = jwtBuilder.compact();
//         System.out.println(token);
//         String[] split = token.split("\\.");
//         //头部
//         System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
//         //负载
//         System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
//         //签名 盐
//         System.out.println(Base64Codec.BASE64.decodeToString(split[2]));
//         return token;
//     }
//
//    /**
//     * JWT解析token
//     */
////    @Test
////    void parseToken(){
////        // String token=testJwt();
////         String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyMjIiLCJzdWIiOiJhZG1pbiIsImlhdCI6MTYyODA4NTQyNSwiZXhwIjoxNjI4MDg1NDU1fQ.m8yMcvR93voluP5_a0YWJqk4X89ow3lfxXex6i_YLK0";
////         Claims xxxxxx = Jwts.parser()
////                 .setSigningKey("xxxxxx")
////                 .parseClaimsJws(token)
////                 .getBody();
////         System.out.println("jti"+xxxxxx.getId());//id
////         System.out.println("Subject"+xxxxxx.getSubject());//签发用户
////         System.out.println("IssuedAt"+xxxxxx.getIssuedAt());//签发时间
////         System.out.println("Exp"+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(xxxxxx.getExpiration()));//过期时间
////     }
//
//    /**
//     * JWT生成token  （自定义声明）
//     */
//    @Test
//    public   String  testJwt1(){
//        //获取当前时间戳
//        long now = System.currentTimeMillis();
//        //30秒过期
//        long exp = now + 30 * 1000;
//        Map map=new HashMap();
//        map.put("han","登录");
//        map.put("email","508578631@qq.com");
//        JwtBuilder jwtBuilder = Jwts.builder()
//                //id
//                .setId("222")
//                //签发用户
//                .setSubject("admin")
//                //签发时间
//                .setIssuedAt(new Date())
//                //过期时间
//                //.setExpiration(new Date(exp))
//                .signWith(SignatureAlgorithm.HS256, "xxxxxx")
//                //自定义声明  （map入参）
//                .addClaims(map)
//                .claim("age",19);
//        String token = jwtBuilder.compact();
//        System.out.println(token);
//        String[] split = token.split("\\.");
//        //头部
//        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
//        //负载
//        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
//        //签名 盐
//        System.out.println(Base64Codec.BASE64.decodeToString(split[2]));
//        return token;
//    }
//
//    /**
//     * JWT解析token  （自定义声明）
//     */
//    @Test
//    void parseToken1(){
//         String token=testJwt1();
//        Claims xxxxxx = Jwts.parser()
//                .setSigningKey("xxxxxx")
//                .parseClaimsJws(token)
//                .getBody();
//        System.out.println("jti"+xxxxxx.getId());//id
//        System.out.println("Subject"+xxxxxx.getSubject());//签发用户
//        System.out.println("IssuedAt"+xxxxxx.getIssuedAt());//签发时间
//       // System.out.println("Exp"+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(xxxxxx.getExpiration()));//过期时间
//        System.out.println("我"+xxxxxx.get("han")+"了,邮箱是："+xxxxxx.get("email")+" 年龄："+xxxxxx.get("age"));
//    }
//}
