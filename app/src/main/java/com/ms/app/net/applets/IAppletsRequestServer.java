package com.ms.app.net.applets;

import com.bdlbsc.common.applets.AppletssResponse;
import com.bdlbsc.common.applets.AppletssRequest;
import com.bdlbsc.common.applets.AppletssVersionRequest;
import com.bdlbsc.common.applets.AppletssVersionResponse;


import io.reactivex.Observable;

public interface IAppletsRequestServer {

    /**
     * 请求用户小程序列表版本
     * @param request
     * @return
     */
    Observable<AppletssVersionResponse> appletsVersion(AppletssVersionRequest request);

    /**
     * 请求用户小程序列表
     * @param request
     * @return
     */
    Observable<AppletssResponse> applets(AppletssRequest request);

}
