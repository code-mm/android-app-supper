package com.ms.app.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.ms.app.R;

import org.ms.module.base.view.BaseActivity;
import org.ms.module.base.view.BaseAppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashActivity extends BaseAppCompatActivity {
    private static final String TAG = "SplashActivity";

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected boolean isFullScreen() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        finish();


        Observable.create((ObservableOnSubscribe<Integer>) e -> {
            for (int i = 1; i > -1; i--) {
                e.onNext(i);
                SystemClock.sleep(1000);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(integer -> {
                    if (integer == 0) {

                    }
                });
    }

    @Override
    protected void initView() {

    }
}
