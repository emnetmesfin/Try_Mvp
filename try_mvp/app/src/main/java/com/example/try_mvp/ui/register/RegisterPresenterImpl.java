package com.example.try_mvp.ui.register;

import android.util.Log;

import com.example.try_mvp.data.DataManager;
import com.example.try_mvp.db.User;

public class RegisterPresenterImpl implements RegisterPresenter {

    private RegisterMvpView registerMvpView;
    private RegisterPresenter registerPresenter;
    private DataManager dataManager;

    public RegisterPresenterImpl(RegisterMvpView registerMvpView , DataManager dataManager){
        this.registerMvpView = registerMvpView;
        this.dataManager = dataManager;
        Log.v("1. RegistePres ===> ","was here");
    }

    @Override
    public void onRegisterButtonClick(String name, String password, String confirm) {

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        dataManager.insertUser(user);
        Log.v("2. onRegisterButtonC","was here");
//        registerMvpView = new RegisterActivity();
//        registerMvpView.openLoginActivity();

        // write to database


        // login redirect

        registerMvpView.openLoginActivity();

    }
}
