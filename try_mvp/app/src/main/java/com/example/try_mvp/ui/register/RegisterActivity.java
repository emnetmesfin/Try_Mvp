package com.example.try_mvp.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.try_mvp.R;
import com.example.try_mvp.data.AppDataManager;
import com.example.try_mvp.data.DataManager;
import com.example.try_mvp.db.AppDbHelper;
import com.example.try_mvp.db.DbHelper;
import com.example.try_mvp.db.DbOpenHelper;
import com.example.try_mvp.db.User;
import com.example.try_mvp.prefs.AppPreferencesHelper;
import com.example.try_mvp.prefs.PreferencesHelper;
import com.example.try_mvp.ui.login.LoginActivity;
import com.example.try_mvp.ui.login.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.ViewCollections;

public class RegisterActivity extends AppCompatActivity implements RegisterMvpView{

    @BindView(R.id.username_edit_text2)
    EditText userNameEditText2;

    @BindView(R.id.password_edit_text3)
            EditText passwordEditText;

    @BindView(R.id.confirm_password_edit_text2)
            EditText confirmPasswordEditText;

    @BindView(R.id.register_button)
    Button registerButton;

    AppDataManager appDataManager;
    RegisterMvpView registerMvpView;
    DbOpenHelper dbOpenHelper;
    DbHelper dbHelper;
    PreferencesHelper preferencesHelper;

    DataManager dataManager;
    RegisterPresenter registerPresenter;

    Context packageCxt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);


        registerMvpView = this;
        DbOpenHelper dbOpenHelper = new DbOpenHelper(this,"hi");
        dbHelper = new AppDbHelper(dbOpenHelper);
        dbOpenHelper = new DbOpenHelper(this,"hi");
        preferencesHelper = new AppPreferencesHelper(RegisterActivity.this,"preFile");

        dataManager = new AppDataManager(this,dbHelper,preferencesHelper);
        registerPresenter = new RegisterPresenterImpl(registerMvpView,dataManager);
        Log.v("Oncreate ====> ","is here");
//

//        startActivity(new Intent(this,LoginActivity.class));
        packageCxt = this;
    }

    @Override
    public void openRegisterActivity() {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void openLoginActivity() {
        Intent intent = new Intent(packageCxt, LoginActivity.class);
        Log.v("*********8 ","is here");
        startActivity(intent);
        finish();

//        Log.v("Eroor =====> ",getApplicationContext().getPackageName());

        if(getApplication() == null){
            Log.v("Error ===> ","Null");
        }

        if(this == null){
            Log.v("This is Null ==> ","====> ");

        }


    }


    @OnClick(R.id.register_button)
    void onRegisterButtonClick(View view){

        //userNameEditText2.setText("Emnet");
            registerPresenter.onRegisterButtonClick("email","passworkd","con");


    }

}
