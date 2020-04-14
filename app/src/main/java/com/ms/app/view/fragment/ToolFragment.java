package com.ms.app.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ms.app.R;

import org.ms.module.base.view.BaseFragment;
import org.ms.module.supper.client.Modules;

public class ToolFragment extends BaseFragment implements View.OnClickListener {


    private RecyclerView recyclerViewApplets;
    private ImageView imageViewSearch;


    @Override
    protected void initView() {

        imageViewSearch = (ImageView) findView(R.id.imageViewSearch);
        recyclerViewApplets = (RecyclerView) findView(R.id.recyclerViewApplets);

        imageViewSearch.setOnClickListener(this);


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

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.imageViewSearch:
                Modules.getUtilsModule().getToastUtils().show("搜索");
                break;
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);







    }
}
