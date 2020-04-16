package com.ms.app.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import lombok.Data;

// 数据库表名，默认为类名
@DatabaseTable(tableName = "_user")
public class User {
    // 主键
    @DatabaseField(generatedId = true)
    public int id;
    // name字段唯一
    @DatabaseField(unique = true)
    public String username;

    @DatabaseField
    public String password;


    @DatabaseField
    public String access_token;

    @DatabaseField
    public String refresh_token;

    @DatabaseField
    public long timestamp;
}