package com.ms.app.model.fragment;

import com.ms.app.presenter.fragment.ToolFragmentPresenter;
import com.ms.app.view.fragment.IToolFragment;

import org.ms.module.base.module.BaseModel;

public class ToolFragmentModel  extends BaseModel<ToolFragmentPresenter> implements IToolFragment {


    public ToolFragmentModel(ToolFragmentPresenter presenter) {
        super(presenter);
    }




}