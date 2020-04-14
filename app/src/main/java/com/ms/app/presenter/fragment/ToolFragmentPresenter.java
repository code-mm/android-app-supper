package com.ms.app.presenter.fragment;

import com.ms.app.model.fragment.ToolFragmentModel;
import com.ms.app.view.fragment.ToolFragment;

import org.ms.module.base.presenter.BasePresenter;

public class ToolFragmentPresenter extends BasePresenter<ToolFragmentModel, ToolFragment> {
    public ToolFragmentPresenter(ToolFragment view) {
        super(view);
    }

    @Override
    protected ToolFragmentModel initModel() {
        return new ToolFragmentModel(this);
    }
}
