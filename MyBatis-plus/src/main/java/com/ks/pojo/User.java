package com.ks.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user")
@Data
public class User {
//    @TableId(type = IdType.NONE)//不设置id
//    @TableId(type = IdType.INPUT)//手动输入
 //   @TableId(type = IdType.ID_WORKER)//默认全局唯一id
 //   @TableId(type = IdType.UUID)//全局唯一id uuid
//    @TableId(type = IdType.ID_WORKER_STR)//ID_WORKER 的字符串表示法
@TableId(type = IdType.AUTO)//自增ID 数据库也要id自增
private long id;
private String name;
private int age;
private String email;
//@TableField(fill = FieldFill.INSERT)//默认插入
//private String createTime;
//@TableField(fill = FieldFill.INSERT_UPDATE)//默认更新
//private String updateTime;
//@Version
//private int version;
}
