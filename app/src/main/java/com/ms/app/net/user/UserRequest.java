package com.ms.app.net.user;

import com.bdlbsc.common.Result;
import com.bdlbsc.common.api.USERAPI;
import com.bdlbsc.common.user.UserLoginPhonenumberRequest;
import com.bdlbsc.common.user.UserLoginPhonenumberRequestVerificationCodeRequest;
import com.bdlbsc.common.user.UserLoginPhonenumberResponse;
import com.bdlbsc.common.user.UserLoginUsernameRequest;
import com.bdlbsc.common.user.UserLoginUsernameResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.ms.module.supper.client.Modules;
import org.ms.module.supper.inter.net.Response;

import java.lang.reflect.Type;

import io.reactivex.Observable;


public class UserRequest implements IUserRequestServer{
    public UserRequest() {

    }

    @Override
    public Observable<UserLoginUsernameResponse> userLoginUsername(UserLoginUsernameRequest request) {
        return Observable.create(emitter -> {
            String requestBody = Modules.getUtilsModule().getGsonUtils().toJson(request);
            Response response = Modules.getRequestModule().requestBody(null, Modules.getApiModule().getBaseUrl() + USERAPI.LOGIN_PHONENUMBER, requestBody);
            int code = response.code;
            if (code == 200) {
                String body = response.body;

                Type type = new TypeToken<Result<UserLoginUsernameResponse>>() {
                }.getType();

                Object o = Modules.getUtilsModule().getGsonUtils().fromJson(body, type);

                Result<UserLoginUsernameResponse> result = (Result<UserLoginUsernameResponse>) o;

                UserLoginUsernameResponse data = result.getData();

                emitter.onNext(data);
            }else{

            }
        });
    }

    @Override
    public Observable<UserLoginPhonenumberRequestVerificationCodeRequest> userLoginPhonenumberVerificationCode(UserLoginPhonenumberRequestVerificationCodeRequest request) {
        return null;
    }

    @Override
    public Observable<UserLoginPhonenumberResponse> userLoginPhonenumber(UserLoginPhonenumberRequest request) {
        return null;
    }
}
