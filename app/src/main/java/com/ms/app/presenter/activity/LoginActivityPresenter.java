package com.ms.app.presenter.activity;

import com.ms.app.model.activity.LoginActivityModel;
import com.ms.app.view.activity.ILoginActivity;
import com.ms.app.view.activity.LoginActivity;

import org.ms.module.base.presenter.BasePresenter;

public class LoginActivityPresenter extends BasePresenter<LoginActivityModel, LoginActivity> implements ILoginActivity {

    public LoginActivityPresenter(LoginActivity view) {
        super(view);
    }

    @Override
    protected LoginActivityModel initModel() {
        return new LoginActivityModel(this);
    }

    @Override
    public void login(String username, String password) {

        if (username == null || "".equals(username)) {

            return;
        }

        if (password == null || "".equals(password)) {

            return;
        }

        model.login(username, password);

    }

    @Override
    public void onLoginResultCallBack() {
        view.onLoginResultCallBack();
    }
}
