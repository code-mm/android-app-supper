package com.ms.app.net.applets;

import android.util.Log;

import com.bdlbsc.common.Result;
import com.bdlbsc.common.api.APPLETSAPI;
import com.bdlbsc.common.applets.AppletssRequest;
import com.bdlbsc.common.applets.AppletssResponse;
import com.bdlbsc.common.applets.AppletssVersionRequest;
import com.bdlbsc.common.applets.AppletssVersionResponse;
import com.google.gson.reflect.TypeToken;
import com.ms.app.net.BaseRequest;

import org.ms.module.supper.client.Modules;
import org.ms.module.supper.inter.net.Response;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import okio.Timeout;

public class AppletsRequest extends BaseRequest implements IAppletsRequestServer {

    private static final String TAG = "AppletsRequest";

    private AppletsRequest() {
    }

    private static AppletsRequest instance;

    public static AppletsRequest getInstance() {
        if (instance == null) {
            synchronized (AppletsRequest.class) {
                instance = new AppletsRequest();
            }
        }
        return instance;
    }


    protected Map<String, Integer> reConnectCount = new HashMap<>();

    private int defaultCount = 5;


    @Override
    public Observable<AppletssVersionResponse> appletsVersion(AppletssVersionRequest request) {
        return Observable.create(emitter -> {
            reConnectCount.put("appletsVersion", 0);
            requestAppletsVersion(request, Modules.getApiModule().getBaseUrl() + APPLETSAPI.APPLETS_GET_VERSION, emitter, "appletsVersion");
        });
    }


    /**
     * @param request
     * @param url
     * @param emitter
     * @param tag     从试中断
     */
    protected void requestAppletsVersion(com.bdlbsc.common.base.BaseRequest request, String url, ObservableEmitter<AppletssVersionResponse> emitter, String tag) {
        String requestBody = Modules.getUtilsModule().getGsonUtils().toJson(request);
        Response response = Modules.getRequestModule().requestBody(headers(), url, requestBody);

        Modules.getLogModule().e(TAG, "response : " + Modules.getUtilsModule().getGsonUtils().toJson(response));

        if (response == null) {
            Integer count = reConnectCount.get(tag);
            if (0 < count && count < defaultCount) {
                count++;
                reConnectCount.put(tag, count);
                requestAppletsVersion(request, url, emitter, tag);
            }
        }

        if (response.throwable != null) {
            if (response.throwable instanceof java.net.SocketTimeoutException) {
                Integer count = reConnectCount.get(tag);
                if (0 < count && count < defaultCount) {
                    count++;
                    reConnectCount.put(tag, count);
                    requestAppletsVersion(request, url, emitter, tag);
                }
            }
        }

        Modules.getLogModule().e(TAG, "code : " + response.code);
        Modules.getLogModule().json(TAG, response.body);
        int code = response.code;
        if (code == 200) {
            String body = response.body;
            Type type = new TypeToken<Result<AppletssVersionResponse>>() {
            }.getType();
            Object o = Modules.getUtilsModule().getGsonUtils().fromJson(body, type);
            Result<AppletssVersionResponse> result = (Result<AppletssVersionResponse>) o;
            AppletssVersionResponse data = result.getData();
            emitter.onNext(data);
        } else {
            emitter.onError(new Exception("" + code));
        }
    }


    @Override
    public Observable<AppletssResponse> applets(AppletssRequest request) {
        return Observable.create(emitter -> {
            reConnectCount.put("applets", 0);
            requestApplets(request, Modules.getApiModule().getBaseUrl() + APPLETSAPI.APPLETS_GET_APPS, emitter, "applets");
        });
    }

    /**
     * @param request
     * @param url
     * @param emitter
     * @param tag     从试中断
     */
    protected void requestApplets(com.bdlbsc.common.base.BaseRequest request, String url, ObservableEmitter<AppletssResponse> emitter, String tag) {
        String requestBody = Modules.getUtilsModule().getGsonUtils().toJson(request);
        Response response = Modules.getRequestModule().requestBody(headers(), url, requestBody);

        Modules.getLogModule().e(TAG, "response : " + Modules.getUtilsModule().getGsonUtils().toJson(response));

        if (response == null) {
            Integer count = reConnectCount.get(tag);
            if (0 < count && count < defaultCount) {
                count++;
                reConnectCount.put(tag, count);
                requestApplets(request, url, emitter, tag);
            }
        }

        if (response.throwable != null) {
            if (response.throwable instanceof java.net.SocketTimeoutException) {
                Integer count = reConnectCount.get(tag);
                if (0 < count && count < defaultCount) {
                    count++;
                    reConnectCount.put(tag, count);
                    requestApplets(request, url, emitter, tag);
                }
            }
        }

        Modules.getLogModule().e(TAG, "code : " + response.code);
        Modules.getLogModule().json(TAG, response.body);
        int code = response.code;
        if (code == 200) {
            String body = response.body;
            Type type = new TypeToken<Result<AppletssResponse>>() {
            }.getType();
            Object o = Modules.getUtilsModule().getGsonUtils().fromJson(body, type);
            Result<AppletssResponse> result = (Result<AppletssResponse>) o;
            AppletssResponse data = result.getData();
            emitter.onNext(data);
        } else {
            emitter.onError(new Exception("" + code));
        }
    }
}
