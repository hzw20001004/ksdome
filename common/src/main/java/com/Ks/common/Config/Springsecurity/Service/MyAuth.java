package com.Ks.common.Config.Springsecurity.Service;



import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface MyAuth {
    /**
     * 自定义权限过滤 放行
     */
    boolean HasPermission(HttpServletRequest request, Authentication authentication);
}
