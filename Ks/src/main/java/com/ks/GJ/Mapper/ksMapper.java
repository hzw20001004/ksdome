package com.ks.GJ.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname ksMapper
 * @Date 2021/8/20 20:25
 * @Created H 508578631@qq.com
 * Ks 代表该模块的顶级名称
 */
public interface ksMapper<T> extends BaseMapper<T> {
    /**
     * 自定义批量插入
     *
     * 如果要自动填充，@Param(xx) xx参数名必须是 list/collection/array 3个的其中之一
     */
    int insertBatch(@Param("list") List<T> list);

//    /**
//     * 自定义批量更新，条件为主键
//     * 如果要自动填充，@Param(xx) xx参数名必须是 list/collection/array 3个的其中之一
//     */
//    int updateBatch(@Param("list") List<T> list);
//
    /**
     * 查询单条数据
     * @param id 单据的id
     * @return   返回的值
     */
    T selectByIdKs(Serializable id, String Ks);










































































}