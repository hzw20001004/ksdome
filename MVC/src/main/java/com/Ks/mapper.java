package com.Ks;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 数据库访问层
 *
 * @author makejava
 * @since 2024-06-18 18:48:11
 */
@Mapper
public interface mapper extends BaseMapper {

    @Select("  ${ew.customSqlSegment}  " )
    Page todayRank(Page p, @Param(Constants.WRAPPER) QueryWrapper betwee);



}

