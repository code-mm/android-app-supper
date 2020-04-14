package com.ms.app.view.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.alipay.mobile.antui.bar.AUTabBarItem;
import com.alipay.mobile.antui.basic.AULinearLayout;
import com.ms.app.R;
import com.ms.app.view.fragment.MessageFragment;
import com.ms.app.view.fragment.MyFragment;
import com.ms.app.view.fragment.ShoppingCartFragment;
import com.ms.app.view.fragment.ToolFragment;

import org.ms.module.base.utils.RxView;
import org.ms.module.base.view.BaseActivity;
import org.ms.module.base.view.BaseAppCompatActivity;
import org.ms.module.base.view.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseAppCompatActivity implements View.OnClickListener {


    // 存放Fragment
    FrameLayout frameLayoutFragment;

    //底部导航布局
    private AULinearLayout auLinearLayoutBottonNavigation;

    // 消息
    private AUTabBarItem auTabBarItemMessage;

    // 工具
    private AUTabBarItem auTabBarItemTool;

    // 购物车
    private AUTabBarItem auTabBarItemShoppingCart;

    // 我的
    private AUTabBarItem auTabBarItemMy;


    private List<Fragment> fragments = new ArrayList<>();


    private void reSetSelected() {

        auTabBarItemMessage.setSelected(false);
        auTabBarItemTool.setSelected(false);
        auTabBarItemShoppingCart.setSelected(false);
        auTabBarItemMy.setSelected(false);

    }

    @Override
    protected void initView() {

        frameLayoutFragment = (FrameLayout) findView(R.id.frameLayoutFragment);
        auLinearLayoutBottonNavigation = (AULinearLayout) findView(R.id.auLinearLayoutBottonNavigation);
        auTabBarItemMessage = (AUTabBarItem) findView(R.id.auTabBarItemMessage);
        auTabBarItemTool = (AUTabBarItem) findView(R.id.auTabBarItemTool);
        auTabBarItemShoppingCart = (AUTabBarItem) findView(R.id.auTabBarItemShoppingCart);
        auTabBarItemMy = (AUTabBarItem) findView(R.id.auTabBarItemMy);
        auTabBarItemMessage.setSelected(true);


        auTabBarItemMessage.setOnClickListener(this);
        auTabBarItemTool.setOnClickListener(this);
        auTabBarItemShoppingCart.setOnClickListener(this);
        auTabBarItemMy.setOnClickListener(this);

    }


    private void showFragment(Fragment fragment) {
        for (Fragment it : fragments) {
            fragmentManager.beginTransaction().hide(it).commit();
        }
        fragmentManager.beginTransaction().show(fragment).commit();
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean isFullScreen() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT)
        {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }


        fragments.clear();
        fragments.add(MessageFragment.newInstance());
        fragments.add(ToolFragment.newInstance());
        fragments.add(ShoppingCartFragment.newInstance());
        fragments.add(MyFragment.newInstance());


        for (Fragment it : fragments) {
            fragmentManager.beginTransaction().add(R.id.frameLayoutFragment, it).commit();
        }


        showFragment(fragments.get(0));
    }


    @Override
    protected void setStatusBar() {



    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {


            case R.id.auTabBarItemMessage:
                reSetSelected();
                auTabBarItemMessage.setSelected(true);
                showFragment(fragments.get(0));
                break;

            case R.id.auTabBarItemTool:
                reSetSelected();
                auTabBarItemTool.setSelected(true);
                showFragment(fragments.get(1));
                break;

            case R.id.auTabBarItemShoppingCart:
                reSetSelected();
                auTabBarItemShoppingCart.setSelected(true);
                showFragment(fragments.get(2));
                break;

            case R.id.auTabBarItemMy:
                reSetSelected();
                auTabBarItemMy.setSelected(true);
                showFragment(fragments.get(3));
                break;
        }
    }
}
