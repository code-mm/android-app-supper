package com.ms.app.view.activity;

import org.ms.module.base.inter.IView;

public interface ILoginActivity extends IView {

    void login(String username, String password);

    void onLoginResultCallBack();


}
