package com.Ks.common.Utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Classname SpringContextHelper
 * @Date 2022/1/19 14:10
 * @Created Ks 获取已注册的 bean
 */
@Component
public class SpringBeanUtils implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringBeanUtils.applicationContext = applicationContext;
  }

  public static Object getBean(Class<?> clazz) throws BeansException {
    return applicationContext.getBean(clazz);
  }

  public static Object getBean(String name) throws BeansException {
    return applicationContext.getBean(name);
  }
}
