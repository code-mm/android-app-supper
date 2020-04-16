package com.ms.app.db;

import com.bdlbsc.common.applets.AppletssResponse;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//小程序缓冲
@DatabaseTable(tableName = "_applets")
public class Applets {

    // 主键
    @DatabaseField(generatedId = true)
    public int id;

    // 缓冲数据
    @DatabaseField
    String data;

    //版本
    @DatabaseField
    int version;

}
