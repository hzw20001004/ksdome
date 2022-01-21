package com.Ks.Config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * @Classname MeatObjectHandler
 * @Date 2022/1/20 13:39
 * @Created Ks 插入修改动作加入默认值
 * 实体类具体注解  @TableField(fill = FieldFill.INSERT)
 */
@Component
public class MeatObjectHandler implements MetaObjectHandler {
  @Override
  public void insertFill(MetaObject metaObject) {
    this.setFieldValByName("appointmentTime", Calendar.getInstance().getTime(), metaObject);

  }

  @Override
  public void updateFill(MetaObject metaObject) {
    this.setFieldValByName("appointmentTime", Calendar.getInstance().getTime(), metaObject);
  }

}
