package com.example.try_mvp.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.try_mvp.MvpApp;

import butterknife.Unbinder;

public class BaseActivity extends AppCompatActivity
       implements MvpView , BaseFragment.Callback {

   // private ActivityComponent mActivityComponent;

    private Unbinder mUnBinder;

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mActivityComponent = DaggerActivityComponent.builder()
//                .activityModule(new ActivityModule(this))
//                .applicationComponent(((MvpApp) getApplication()).getComponent())
//                .build();
//
//    }
    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}
