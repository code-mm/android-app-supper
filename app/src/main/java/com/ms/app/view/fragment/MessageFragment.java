package com.ms.app.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ms.app.R;

import org.ms.module.base.view.BaseFragment;

import static com.bumptech.glide.request.RequestOptions.centerCropTransform;

public class MessageFragment extends BaseFragment {


    private ImageView imageView;

    @Override
    protected void initView() {

        imageView = (ImageView) findView(R.id.imageView);
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Glide.with(this)
                .load("http://maohuawei-dev.oss-cn-beijing.aliyuncs.com/android/images/image_add_user.png")
                //.load("https://www.baidu.com/img/bd_logo1.png")
                .apply(centerCropTransform())
                .into(imageView);

    }
}
