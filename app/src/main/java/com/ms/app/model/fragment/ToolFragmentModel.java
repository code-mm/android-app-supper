package com.ms.app.model.fragment;

import com.bdlbsc.common.applets.AppletssRequest;
import com.bdlbsc.common.applets.AppletssResponse;
import com.ms.app.net.applets.AppletsRequest;
import com.ms.app.net.applets.IAppletsRequestServer;
import com.ms.app.presenter.fragment.ToolFragmentPresenter;
import com.ms.app.view.fragment.IToolFragment;

import org.ms.module.base.module.BaseModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ToolFragmentModel extends BaseModel<ToolFragmentPresenter> implements IToolFragment {


    IAppletsRequestServer appletsRequestServer = AppletsRequest.getInstance();

    public ToolFragmentModel(ToolFragmentPresenter presenter) {
        super(presenter);
    }

    @Override
    public void requestApplets() {
        AppletssRequest request = AppletssRequest.builder().user_id("").build();
        appletsRequestServer.applets(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AppletssResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(AppletssResponse appletssResponse) {
                        onRequestAppletsResultCallBack(appletssResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        presenter.showToast(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void onRequestAppletsResultCallBack(AppletssResponse response) {
        presenter.onRequestAppletsResultCallBack(response);
    }
}