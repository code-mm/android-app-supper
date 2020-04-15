package com.ms.app.view.fragment;

import com.bdlbsc.common.applets.AppletssResponse;
import com.google.gson.internal.$Gson$Preconditions;

import org.ms.module.base.inter.IView;

public interface IToolFragment extends IView {

    // 请求小程序列表
    void requestApplets();

    // 小程序请求结果
    void onRequestAppletsResultCallBack(AppletssResponse response);

}
