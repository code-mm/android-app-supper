package com.ms.app.view.fragment;


import android.os.Bundle;

import com.ms.app.R;

import org.ms.module.base.view.BaseFragment;

public class MessageFragment extends BaseFragment {
    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_message;
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    public static MessageFragment newInstance() {

        Bundle args = new Bundle();

        MessageFragment fragment = new MessageFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
