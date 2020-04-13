package com.ms.app.net.user;

import com.bdlbsc.common.user.UserLoginUsernameRequest;

import org.ms.module.supper.client.Modules;
import org.ms.module.supper.inter.net.Response;

import io.reactivex.Observable;



public class UserRequest {
    public UserRequest() {

    }

    public Observable<Response> userLoginUsername(UserLoginUsernameRequest request) {
        return Observable.create(emitter -> {
            String requestBody = Modules.getUtilsModule().getGsonUtils().toJson(request);
            Response response = Modules.getRequestModule().requestBody(null, Modules.getApiModule().getBaseUrl(), requestBody);
            emitter.onNext(response);
        });
    }
}
