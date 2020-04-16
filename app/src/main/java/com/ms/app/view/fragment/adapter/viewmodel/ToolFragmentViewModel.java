package com.ms.app.view.fragment.adapter.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.bdlbsc.common.applets.AppletssResponse;

public class ToolFragmentViewModel extends ViewModel {

    MutableLiveData<AppletssResponse> appletssResponseMutableLiveData=new MutableLiveData<>();

    public MutableLiveData<AppletssResponse> getAppletssResponseMutableLiveData() {
        return appletssResponseMutableLiveData;
    }
}
