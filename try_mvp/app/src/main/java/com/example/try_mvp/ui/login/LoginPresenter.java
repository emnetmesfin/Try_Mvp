package com.example.try_mvp.ui.login;

public interface LoginPresenter {

    void onLoginButtonClick(String username, String password);

    Boolean isValidd(String username, String password);

    void onDestroy();
}
