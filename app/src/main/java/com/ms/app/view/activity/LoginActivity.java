package com.ms.app.view.activity;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.alipay.mobile.antui.basic.AUButton;
import com.ms.app.R;
import com.ms.app.presenter.LoginActivityPresenter;
import com.ms.app.rsocket.RSocketCallBack;

import org.ms.module.base.view.BaseActivity;
import org.ms.module.supper.client.Modules;

import io.rsocket.RSocket;

@RequiresApi(api = Build.VERSION_CODES.N)
public class LoginActivity extends BaseActivity<LoginActivityPresenter> implements ILoginActivity {


    private static final String TAG = "LoginActivity";

    private AUButton auButtonLogin;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }


    @Override
    protected void initView() {
        super.initView();
        auButtonLogin = findViewById(R.id.auButtonLogin);


        auButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    private RSocket rSocket;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showDialog();


        UserSdk.getInstance().setHost("192.168.0.43").setPort(38000).connect(new RSocketCallBack() {
            @Override
            public void onSuccess(Object o) {

                Modules.getUtilsModule().getToastUtils().show("连接成功");
            }

            @Override
            public void onFailure(Object o) {
                super.onFailure(o);
            }
        });
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
