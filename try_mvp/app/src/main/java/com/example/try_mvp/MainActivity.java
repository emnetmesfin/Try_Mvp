package com.example.try_mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.try_mvp.data.AppDataManager;
import com.example.try_mvp.data.DataManager;
import com.example.try_mvp.db.AppDbHelper;
import com.example.try_mvp.db.DbHelper;
import com.example.try_mvp.db.DbOpenHelper;
import com.example.try_mvp.prefs.AppPreferencesHelper;
import com.example.try_mvp.prefs.PreferencesHelper;
import com.example.try_mvp.ui.login.LoginActivity;
import com.example.try_mvp.ui.login.LoginPresenter;
import com.example.try_mvp.ui.login.LoginPresenterImpl;
import com.example.try_mvp.ui.login.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    LoginPresenter mPresenter;
    LoginView mloginView;

    @BindView(R.id.username_edit_text)
    EditText muserNameEditText;

    @BindView(R.id.password_edit_text)
    EditText mpasswordEditText;

    @BindView(R.id.login_button)
    Button mloginButton;

    @BindView(R.id.account_tv)
    TextView accountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
}
