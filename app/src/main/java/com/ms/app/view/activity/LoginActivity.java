package com.ms.app.view.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ms.app.R;
import com.ms.app.presenter.LoginActivityPresenter;

import org.ms.module.base.view.BaseActivity;

public class LoginActivity extends BaseActivity<LoginActivityPresenter> implements ILoginActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showDialog();
    }

    @Override
    public void login(String username, String password) {

    }

    @Override
    public void onLoginResultCallBack() {

    }

    @Override
    protected LoginActivityPresenter initPresenter() {
        return new LoginActivityPresenter(this);
    }
}
