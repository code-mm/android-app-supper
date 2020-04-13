package com.ms.app.net.user;

import com.bdlbsc.common.user.UserLoginUsernameRequest;
import com.bdlbsc.common.user.UserLoginUsernameResponse;

import io.reactivex.Observable;

public interface IUserRequestServer {

    Observable<UserLoginUsernameResponse> loginUsername(UserLoginUsernameRequest request);


}
