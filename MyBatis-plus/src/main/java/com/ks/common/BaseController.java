// +----------------------------------------------------------------------
// | JavaWeb混编版框架 [ JavaWeb ]
// +----------------------------------------------------------------------
// | 版权所有 2019~2020 南京JavaWeb研发中心
// +----------------------------------------------------------------------
// | 官方网站: http://www.javaweb.vip/
// +----------------------------------------------------------------------
// | 作者: 鲲鹏 <1175401194@qq.com>
// +----------------------------------------------------------------------

package com.ks.common;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 基类控制器
 */
public class BaseController {
    /**
     * 列表页
     *
     * @return
     */
    @GetMapping("/list")
    public List<User> index() {
        return null;
    }

}
