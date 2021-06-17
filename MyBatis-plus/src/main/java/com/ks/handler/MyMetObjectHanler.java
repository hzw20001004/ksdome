package com.ks.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;


public class MyMetObjectHanler implements MetaObjectHandler {
    //插入时填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("插入");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);

    }
    //新增时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("修改");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
