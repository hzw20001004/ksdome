package com.ks.GJ.Mapper;

import com.ks.GJ.Mapper.Insert.insertBatch.InsertBatchKsSql;
import com.ks.GJ.Mapper.Select.selectByIdKs.selectByIdKsSql;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Classname MapperConfig
 * @Date 2021/11/14 20:40
 * @Created Ks
 */
@Configuration

public class MapperConfig {
    //加入自定义mapper   可以连续新增
    @Bean("InsertBatchKs")
    @Primary
    public InsertBatchKsSql InsertBatchKsSql() {
        return new InsertBatchKsSql();
    }
    //加入自定义mapper   单挑动态查询
    @Bean
    public selectByIdKsSql selectByIdKsSql() {
        return new selectByIdKsSql();
    }





}
