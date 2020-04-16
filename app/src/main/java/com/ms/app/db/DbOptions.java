package com.ms.app.db;

import org.ms.module.supper.client.Modules;

public class DbOptions {

    private static final DbOptions instance = new DbOptions();

    public static DbOptions getInstance() {
        return instance;
    }

    UserOrmLiteSqliteOpenHelper userOrmLiteSqliteOpenHelper;

    private DbOptions() {
        userOrmLiteSqliteOpenHelper = new UserOrmLiteSqliteOpenHelper(Modules.getDataModule().getAppData().getApplication());
    }
}