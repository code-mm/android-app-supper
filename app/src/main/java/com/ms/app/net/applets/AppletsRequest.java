package com.ms.app.net.applets;

import com.bdlbsc.common.Result;
import com.bdlbsc.common.api.APPLETSAPI;
import com.bdlbsc.common.api.USERAPI;
import com.bdlbsc.common.applets.AppletssResponse;
import com.bdlbsc.common.user.UserTokenCheckResponse;
import com.google.gson.reflect.TypeToken;

import org.ms.module.supper.client.Modules;
import org.ms.module.supper.inter.net.Response;

import java.lang.reflect.Type;

import io.reactivex.Observable;

public class AppletsRequest implements IAppletsRequestServer {
    @Override
    public Observable<AppletssResponse> applets(AppletsRequest request) {
        return Observable.create(emitter -> {
            String requestBody = Modules.getUtilsModule().getGsonUtils().toJson(request);
            Response response = Modules.getRequestModule().requestBody(null, Modules.getApiModule().getBaseUrl() + APPLETSAPI.APPLETS_GET_APPS, requestBody);
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
        });
    }
}
