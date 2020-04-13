package com.ms.app.model;

import com.bdlbsc.common.user.UserLoginUsernameRequest;
import com.bdlbsc.common.user.UserLoginUsernameResponse;
import com.ms.app.net.user.IUserRequestServer;
import com.ms.app.net.user.UserRequest;
import com.ms.app.presenter.LoginActivityPresenter;
import com.ms.app.view.activity.ILoginActivity;

import org.ms.module.base.module.BaseModel;
import org.ms.module.supper.client.Modules;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginActivityModel extends BaseModel<LoginActivityPresenter> implements ILoginActivity {

    private IUserRequestServer userRequestServer = UserRequest.getInstance();

    public LoginActivityModel(LoginActivityPresenter presenter) {
        super(presenter);

    }

    @Override
    public void login(String username, String password) {
        UserLoginUsernameRequest request = UserLoginUsernameRequest.builder().username(username).password(password).build();
        userRequestServer.userLoginUsername(request).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserLoginUsernameResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserLoginUsernameResponse userLoginUsernameResponse) {


                        String access_token = userLoginUsernameResponse.getAccess_token();
                        String refresh_token = userLoginUsernameResponse.getRefresh_token();

                        Modules.getDataModule().getUserData().setUsername(username);
                        Modules.getDataModule().getUserData().setPassword(password);
                        Modules.getDataModule().getUserData().setAccessToken(access_token);
                        Modules.getDataModule().getUserData().setRefreshToken(refresh_token);


                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onLoginResultCallBack() {

    }
}
