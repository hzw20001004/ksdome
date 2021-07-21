
package com.ks.common.Config.Springsecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * EnableWebSecurity注解使得SpringMVC集成了Spring Security的web安全支持
 */
@EnableWebSecurity
class SpringsecurityConfig extends WebSecurityConfigurerAdapter {

}
