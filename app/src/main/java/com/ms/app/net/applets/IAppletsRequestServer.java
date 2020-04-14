package com.ms.app.net.applets;

import com.bdlbsc.common.applets.AppletssResponse;
import com.bdlbsc.common.user.UserTokenCheckRequest;
import com.bdlbsc.common.user.UserTokenCheckResponse;

import io.reactivex.Observable;

public interface IAppletsRequestServer {

    Observable<AppletssResponse> applets(AppletsRequest request);

}
