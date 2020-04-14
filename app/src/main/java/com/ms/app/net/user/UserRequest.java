package com.ms.app.net.user;

import com.bdlbsc.common.Result;
import com.bdlbsc.common.api.USERAPI;
import com.bdlbsc.common.user.UserLoginPhonenumberRequest;
import com.bdlbsc.common.user.UserLoginPhonenumberRequestVerificationCodeRequest;
import com.bdlbsc.common.user.UserLoginPhonenumberResponse;
import com.bdlbsc.common.user.UserLoginUsernameRequest;
import com.bdlbsc.common.user.UserLoginUsernameResponse;
import com.bdlbsc.common.user.UserRegisteredPhonenumberRequest;
import com.bdlbsc.common.user.UserRegisteredPhonenumberRequestVerifocationCodeRequest;
import com.bdlbsc.common.user.UserRegisteredPhonenumberResponse;
import com.bdlbsc.common.user.UserRegisteredUsernameRequest;
import com.bdlbsc.common.user.UserRegisteredUsernameResponse;
import com.bdlbsc.common.user.UserTokenCheckRequest;
import com.bdlbsc.common.user.UserTokenCheckResponse;
import com.bdlbsc.common.user.UserTokenRefreshResponse;
import com.google.gson.reflect.TypeToken;

import org.ms.module.supper.client.Modules;
import org.ms.module.supper.inter.net.Response;

import java.lang.reflect.Type;

import io.reactivex.Observable;


public class UserRequest implements IUserRequestServer {


    private UserRequest() {
    }

    private static UserRequest instance;

    public static UserRequest getInstance() {
        if (instance == null) {
            synchronized (UserRequest.class) {
                instance = new UserRequest();
            }
        }
        return instance;
    }

    @Override
    public Observable<UserTokenCheckResponse> userTokenCheck(UserTokenCheckRequest request) {
        return Observable.create(emitter -> {
            String requestBody = Modules.getUtilsModule().getGsonUtils().toJson(request);
            Response response = Modules.getRequestModule().requestBody(null, Modules.getApiModule().getBaseUrl() + USERAPI.TOKEN_CHECK, requestBody);
            int code = response.code;
            if (code == 200) {
                String body = response.body;
                Type type = new TypeToken<Result<UserTokenCheckResponse>>() {
                }.getType();
                Object o = Modules.getUtilsModule().getGsonUtils().fromJson(body, type);
                Result<UserTokenCheckResponse> result = (Result<UserTokenCheckResponse>) o;
                UserTokenCheckResponse data = result.getData();
                emitter.onNext(data);
            } else {
                emitter.onError(new Exception("" + code));
            }
        });
    }

    @Override
    public Observable<UserTokenRefreshResponse> userTokenRefresh(UserTokenCheckRequest request) {
        return Observable.create(emitter -> {
            String requestBody = Modules.getUtilsModule().getGsonUtils().toJson(request);
            Response response = Modules.getRequestModule().requestBody(null, Modules.getApiModule().getBaseUrl() + USERAPI.TOKEN_REFRESH, requestBody);
            int code = response.code;
            if (code == 200) {
                String body = response.body;
                Type type = new TypeToken<Result<UserTokenRefreshResponse>>() {
                }.getType();
                Object o = Modules.getUtilsModule().getGsonUtils().fromJson(body, type);
                Result<UserTokenRefreshResponse> result = (Result<UserTokenRefreshResponse>) o;
                UserTokenRefreshResponse data = result.getData();
                emitter.onNext(data);
            } else {
                emitter.onError(new Exception("" + code));
            }
        });
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
            } else {

                emitter.onError(new Exception("" + code));

            }
        });
    }

    @Override
    public Observable<UserLoginPhonenumberRequestVerificationCodeRequest> userLoginPhonenumberVerificationCode(UserLoginPhonenumberRequestVerificationCodeRequest request) {
        return Observable.create(emitter -> {
            String requestBody = Modules.getUtilsModule().getGsonUtils().toJson(request);
            Response response = Modules.getRequestModule().requestBody(null, Modules.getApiModule().getBaseUrl() + USERAPI.LOGIN_PHONENUMBER_REQUEST_VERIFICATIONCODE, requestBody);
            int code = response.code;
            if (code == 200) {
                String body = response.body;

                Type type = new TypeToken<Result<UserLoginPhonenumberRequestVerificationCodeRequest>>() {
                }.getType();

                Object o = Modules.getUtilsModule().getGsonUtils().fromJson(body, type);

                Result<UserLoginPhonenumberRequestVerificationCodeRequest> result = (Result<UserLoginPhonenumberRequestVerificationCodeRequest>) o;

                UserLoginPhonenumberRequestVerificationCodeRequest data = result.getData();

                emitter.onNext(data);
            } else {
                emitter.onError(new Exception("" + code));
            }
        });
    }

    @Override
    public Observable<UserLoginPhonenumberResponse> userLoginPhonenumber(UserLoginPhonenumberRequest request) {
        return Observable.create(emitter -> {
            String requestBody = Modules.getUtilsModule().getGsonUtils().toJson(request);
            Response response = Modules.getRequestModule().requestBody(null, Modules.getApiModule().getBaseUrl() + USERAPI.LOGIN_PHONENUMBER, requestBody);
            int code = response.code;
            if (code == 200) {
                String body = response.body;

                Type type = new TypeToken<Result<UserLoginPhonenumberResponse>>() {
                }.getType();

                Object o = Modules.getUtilsModule().getGsonUtils().fromJson(body, type);

                Result<UserLoginPhonenumberResponse> result = (Result<UserLoginPhonenumberResponse>) o;

                UserLoginPhonenumberResponse data = result.getData();

                emitter.onNext(data);
            } else {
                emitter.onError(new Exception("" + code));
            }
        });
    }

    @Override
    public Observable<UserRegisteredUsernameResponse> userRegisteredUsername(UserRegisteredUsernameRequest request) {
        return Observable.create(emitter -> {
            String requestBody = Modules.getUtilsModule().getGsonUtils().toJson(request);
            Response response = Modules.getRequestModule().requestBody(null, Modules.getApiModule().getBaseUrl() + USERAPI.REGISTERED_USERNAME, requestBody);
            int code = response.code;
            if (code == 200) {
                String body = response.body;

                Type type = new TypeToken<Result<UserRegisteredUsernameResponse>>() {
                }.getType();

                Object o = Modules.getUtilsModule().getGsonUtils().fromJson(body, type);

                Result<UserRegisteredUsernameResponse> result = (Result<UserRegisteredUsernameResponse>) o;

                UserRegisteredUsernameResponse data = result.getData();

                emitter.onNext(data);
            } else {
                emitter.onError(new Exception("" + code));
            }
        });
    }

    @Override
    public Observable<UserRegisteredPhonenumberRequestVerifocationCodeRequest> userRegisteredPhoneVerifocationCode(UserRegisteredPhonenumberRequestVerifocationCodeRequest request) {
        return Observable.create(emitter -> {
            String requestBody = Modules.getUtilsModule().getGsonUtils().toJson(request);
            Response response = Modules.getRequestModule().requestBody(null, Modules.getApiModule().getBaseUrl() + USERAPI.REGISTERED_PHONENUMBER_REQUEST_VERIFICATIONCODE, requestBody);
            int code = response.code;
            if (code == 200) {
                String body = response.body;

                Type type = new TypeToken<Result<UserRegisteredPhonenumberRequestVerifocationCodeRequest>>() {
                }.getType();

                Object o = Modules.getUtilsModule().getGsonUtils().fromJson(body, type);

                Result<UserRegisteredPhonenumberRequestVerifocationCodeRequest> result = (Result<UserRegisteredPhonenumberRequestVerifocationCodeRequest>) o;

                UserRegisteredPhonenumberRequestVerifocationCodeRequest data = result.getData();

                emitter.onNext(data);
            } else {
                emitter.onError(new Exception("" + code));
            }
        });
    }

    @Override
    public Observable<UserRegisteredPhonenumberResponse> userRegisteredPhone(UserRegisteredPhonenumberRequest request) {
        return Observable.create(emitter -> {
            String requestBody = Modules.getUtilsModule().getGsonUtils().toJson(request);
            Response response = Modules.getRequestModule().requestBody(null, Modules.getApiModule().getBaseUrl() + USERAPI.REGISTERED_PHONENUMBER, requestBody);
            int code = response.code;
            if (code == 200) {
                String body = response.body;

                Type type = new TypeToken<Result<UserRegisteredPhonenumberResponse>>() {
                }.getType();

                Object o = Modules.getUtilsModule().getGsonUtils().fromJson(body, type);

                Result<UserRegisteredPhonenumberResponse> result = (Result<UserRegisteredPhonenumberResponse>) o;

                UserRegisteredPhonenumberResponse data = result.getData();

                emitter.onNext(data);
            } else {
                emitter.onError(new Exception("" + code));
            }
        });
    }
}
