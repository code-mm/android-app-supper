package com.ms.app.view.fragment;

import android.os.Bundle;

import com.ms.app.R;

import org.ms.module.base.view.BaseFragment;

public class MyFragment extends BaseFragment {

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_my;
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }


    public static MyFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
