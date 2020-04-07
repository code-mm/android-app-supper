package com.ms.app.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ms.app.R;

import org.ms.module.base.view.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showDialog();
    }
}
