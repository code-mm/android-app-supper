package com.ms.app.model;

import com.ms.app.presenter.LoginActivityPresenter;
import com.ms.app.view.activity.ILoginActivity;

import org.ms.module.base.module.BaseModel;
import org.ms.module.supper.client.Modules;
import org.ms.module.supper.inter.module.Module;

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
