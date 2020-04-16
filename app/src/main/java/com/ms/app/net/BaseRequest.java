package com.ms.app.net;

import com.bdlbsc.common.Result;
import com.bdlbsc.common.applets.AppletssVersionResponse;
import com.google.gson.reflect.TypeToken;

import org.ms.module.supper.client.Modules;
import org.ms.module.supper.inter.net.Response;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.ObservableEmitter;

public class BaseRequest {

    Map<String, String> headers = new HashMap<>();

    protected Map<String, String> headers() {
        headers.put("Content-Type", "application/json");
        return headers;
    }





    private static final String TAG = "BaseRequest";



}
