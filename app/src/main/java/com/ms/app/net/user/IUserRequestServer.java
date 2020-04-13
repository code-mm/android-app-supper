package com.ms.app.net.user;

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
import com.bdlbsc.common.user.UserTokenRefreshRequest;
import com.bdlbsc.common.user.UserTokenRefreshResponse;

import io.reactivex.Observable;

public interface IUserRequestServer {


    /**
     * 检查token是否过期
     *
     * @param request
     * @return
     */
    Observable<UserTokenCheckResponse> userTokenCheck(UserTokenCheckRequest request);

    /**
     * 刷新token
     *
     * @param request
     * @return
     */
    Observable<UserTokenRefreshResponse> userTokenRefresh(UserTokenCheckRequest request);


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

    /**
     * 用户名注册
     *
     * @param request
     * @return
     */
    Observable<UserRegisteredUsernameResponse> userRegisteredUsername(UserRegisteredUsernameRequest request);

    /**
     * 手机号注册请求验证码
     *
     * @param request
     * @return
     */
    Observable<UserRegisteredPhonenumberRequestVerifocationCodeRequest> userRegisteredPhoneVerifocationCode(UserRegisteredPhonenumberRequestVerifocationCodeRequest request);

    /**
     * 手机号注册¡
     *
     * @param request
     * @return
     */
    Observable<UserRegisteredPhonenumberResponse> userRegisteredPhone(UserRegisteredPhonenumberRequest request);


}
