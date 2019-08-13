package com.example.try_mvp.ui.login;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.example.try_mvp.data.DataManager;
import com.example.try_mvp.db.User;
import com.example.try_mvp.prefs.AppPreferencesHelper;
import com.example.try_mvp.prefs.PreferencesHelper;

public class LoginPresenterImpl extends Activity implements LoginPresenter{

    private LoginView loginView;
    private DataManager dataManager;
    private Boolean isValid;
    private PreferencesHelper preferencesHelper;

    public LoginPresenterImpl(LoginView loginView, DataManager dataManager) {
        this.loginView = loginView;
        this.dataManager = dataManager;
    }

    private Context context;


    @Override
    public void onLoginButtonClick(String username, String password) {
        preferencesHelper = new AppPreferencesHelper(this, "preFile");

        if (isValidd(username, password)) {
            User user = new User();
            user.setName(username);
            user.setPassword(password);

            dataManager.insertUser(user);

            preferencesHelper.setCurrentUserPassword(username);
            preferencesHelper.setCurrentUserPassword(password);

            Toast.makeText(this,dataManager.getCurrentUserName(),Toast.LENGTH_SHORT);

        }


        //
        loginView.openDiaryActivity();
    }

    @Override
    public Boolean isValidd(String username, String password) {
        if (username == null || username.isEmpty()) {
            String message = "user name can't be empty";
            Toast.makeText(LoginPresenterImpl.this, message, Toast.LENGTH_SHORT).show();
            isValid = false;

        }
        if (password == null || password.isEmpty()) {
            Toast.makeText(this, "password can't be empty", Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        return isValid;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        loginView = null;
    }
}
