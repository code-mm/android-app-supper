package com.ms.app.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bdlbsc.common.applets.AppletsType;
import com.bdlbsc.common.applets.AppletssResponse;
import com.ms.app.presenter.fragment.ToolFragmentPresenter;

import org.ms.module.base.view.BaseFragment;
import org.ms.module.supper.client.Modules;


import com.ms.app.R;
import com.ms.app.view.fragment.adapter.recycler.RecyclerViewAppletsAdapter;
import com.ms.app.view.fragment.adapter.viewmodel.ToolFragmentViewModel;

import java.util.List;

/**
 * 工具
 */
public class ToolFragment extends BaseFragment<ToolFragmentPresenter> implements View.OnClickListener, IToolFragment {


    private static final String TAG = "ToolFragment";

    // 小程序列表
    private RecyclerView recyclerViewApplets;
    // 搜索按钮
    private ImageView imageViewSearch;
    // ViewModel
    private ToolFragmentViewModel toolFragmentViewModel;
    // 小程序列表适配器
    private RecyclerViewAppletsAdapter recyclerViewAppletsAdapter;


    @Override
    protected ToolFragmentPresenter initPresenter() {
        return new ToolFragmentPresenter(this);
    }

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

        toolFragmentViewModel = ViewModelProviders.of(this).get(ToolFragmentViewModel.class);


        recyclerViewAppletsAdapter = new RecyclerViewAppletsAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewApplets.setLayoutManager(linearLayoutManager);
        recyclerViewApplets.setAdapter(recyclerViewAppletsAdapter);


        // 请求小程序列表
        toolFragmentViewModel.getAppletssResponseMutableLiveData().observe(this, new Observer<AppletssResponse>() {
            @Override
            public void onChanged(@Nullable AppletssResponse response) {
                Log.e(TAG, "onChanged: " + Modules.getUtilsModule().getGsonUtils().toJson(response));
                recyclerViewAppletsAdapter.setAppletssResponse(response);
                recyclerViewAppletsAdapter.notifyDataSetChanged();
            }
        });



        //
        requestApplets();
    }

    @Override
    public void requestApplets() {
        presenter.requestApplets();
    }

    @Override
    public void onRequestAppletsResultCallBack(AppletssResponse response) {
        toolFragmentViewModel.getAppletssResponseMutableLiveData().postValue(response);
    }
}
