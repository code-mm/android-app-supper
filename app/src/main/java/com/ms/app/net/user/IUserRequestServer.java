package com.ms.app.net.user;

import com.bdlbsc.common.user.UserLoginPhonenumberRequest;
import com.bdlbsc.common.user.UserLoginPhonenumberRequestVerificationCodeRequest;
import com.bdlbsc.common.user.UserLoginPhonenumberResponse;
import com.bdlbsc.common.user.UserLoginUsernameRequest;
import com.bdlbsc.common.user.UserLoginUsernameResponse;

import io.reactivex.Observable;

public interface IUserRequestServer {

    /**
     * 用户名登录
     *
     * @param request
     * @return
     */
    Observable<UserLoginUsernameResponse> userLoginUsername(UserLoginUsernameRequest request);

    /**
     * 手机号登录请求验证码
     *
     * @param request
     * @return
     */
    Observable<UserLoginPhonenumberRequestVerificationCodeRequest> userLoginPhonenumberVerificationCode(UserLoginPhonenumberRequestVerificationCodeRequest request);

    /**
     * 手机号登录
     *
     * @param request
     * @return
     */
    Observable<UserLoginPhonenumberResponse> userLoginPhonenumber(UserLoginPhonenumberRequest request);


}
