package com.ks.GJ.Mapper.Insert.insertBatch;

/**
 * @Classname InsertBatchKsSql
 * @Date 2021/8/20 20:36
 * @Created by hzw
 * sql注入器
 */

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.List;

/**
 * 自定义方法SQL注入器
 */
public class InsertBatchKsSql extends DefaultSqlInjector {
    /**
     * 如果只需增加方法，保留mybatis plus自带方法，
     * 可以先获取super.getMethodList()，再添加add
     */
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new InsertBatchKs());
        return methodList;
    }
}
