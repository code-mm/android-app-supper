package com.ms.app.view.fragment;

import android.os.Bundle;

import com.ms.app.R;

import org.ms.module.base.view.BaseFragment;

public class ToolFragment extends BaseFragment {
    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_tool;
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    public static ToolFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ToolFragment fragment = new ToolFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
