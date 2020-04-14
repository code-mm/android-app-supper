package com.ms.app.net.applets;

import com.bdlbsc.common.applets.AppletssResponse;
import com.bdlbsc.common.applets.AppletssRequest;


import io.reactivex.Observable;

public interface IAppletsRequestServer {

    Observable<AppletssResponse> applets(AppletssRequest request);

}
