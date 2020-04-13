package com.ms.app.model;

import com.ms.app.presenter.LoginActivityPresenter;
import com.ms.app.view.activity.ILoginActivity;

import org.ms.module.base.module.BaseModel;

public class LoginActivityModel  extends BaseModel<LoginActivityPresenter> implements ILoginActivity {

    public LoginActivityModel(LoginActivityPresenter presenter) {
        super(presenter);
    }



    @Override
    public void login(String username, String password) {

    }

    @Override
    public void onLoginResultCallBack() {

    }
}
