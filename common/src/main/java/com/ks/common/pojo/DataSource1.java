package com.ks.common.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import com.ks.common.Base.BaseEntity;
import lombok.Data;

/**
 * HZW 2021-07-13 14:39
 */
@Data
@TableName(value = "databasesource")
public class DataSource1 extends BaseEntity {


    private String DatasourceId;

    private String url;

    private String userName;

    private String passWord;

    private String code;

    private String databasetype;
}
