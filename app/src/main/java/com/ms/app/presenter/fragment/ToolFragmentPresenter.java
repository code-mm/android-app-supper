package com.ms.app.presenter.fragment;

import com.bdlbsc.common.applets.AppletssResponse;
import com.ms.app.model.fragment.ToolFragmentModel;
import com.ms.app.view.fragment.IToolFragment;
import com.ms.app.view.fragment.ToolFragment;

import org.ms.module.base.presenter.BasePresenter;

public class ToolFragmentPresenter extends BasePresenter<ToolFragmentModel, ToolFragment>  implements IToolFragment {
    public ToolFragmentPresenter(ToolFragment view) {
        super(view);
    }

    @Override
    protected ToolFragmentModel initModel() {
        return new ToolFragmentModel(this);
    }

    @Override
    public void requestApplets() {
        model.requestApplets();
    }

    @Override
    public void onRequestAppletsResultCallBack(AppletssResponse response) {
        view.onRequestAppletsResultCallBack(response);
    }

    @Override
    public void warning(String text) {

    }
}
