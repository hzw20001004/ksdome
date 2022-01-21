package com.Ks.Pojo;

import com.Ks.Base.BaseEntity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 * 用户对象 sys_user
 *
 * @author ruoyi
 */
@Data
@TableName(value = "sys_user")
public class SysUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    /** 部门ID */
    private Long deptid;



}
