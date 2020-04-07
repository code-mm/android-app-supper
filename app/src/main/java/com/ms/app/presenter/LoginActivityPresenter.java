package com.ms.app.presenter;

import com.ms.app.model.LoginActivityModel;
import com.ms.app.view.activity.ILoginActivity;
import com.ms.app.view.activity.LoginActivity;

import org.ms.module.base.presenter.BasePresenter;
import org.ms.module.supper.client.Modules;

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
