package com.example.try_mvp.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.try_mvp.DiaryActivity;
import com.example.try_mvp.MainActivity;
import com.example.try_mvp.R;
import com.example.try_mvp.data.AppDataManager;
import com.example.try_mvp.data.DataManager;
import com.example.try_mvp.db.AppDbHelper;
import com.example.try_mvp.db.DbHelper;
import com.example.try_mvp.db.DbOpenHelper;
import com.example.try_mvp.db.User;
import com.example.try_mvp.prefs.AppPreferencesHelper;
import com.example.try_mvp.prefs.PreferencesHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    Context packCtx;

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

//    public static Intent getStartIntent(Context context){
//        Intent intent = new Intent(context , LoginActivity.class);
//        return intent;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        AppDataManager appDataManager;
        mloginView = this;
        DbOpenHelper dbOpenHelper = new DbOpenHelper(this,"User");
        DbHelper dbHelper = new AppDbHelper(dbOpenHelper);

        PreferencesHelper preferencesHelper = new AppPreferencesHelper(LoginActivity.this,"preFile");

        DataManager dataManager = new AppDataManager(this,dbHelper,preferencesHelper);
        mPresenter  = new LoginPresenterImpl(mloginView,dataManager);

        packCtx = this;

        if(preferencesHelper.getCurrentUserId() != null || preferencesHelper.getCurrentUserPassword() != null){
            Intent intent = new Intent(this,DiaryActivity.class);
            startActivity(intent);
        }

    }


    @OnClick(R.id.login_button)
    void onLoginClick(View view){
        String userName = muserNameEditText.getText().toString();
        String pass = mpasswordEditText.getText().toString();



//        if(){
//
//        }
        mPresenter.onLoginButtonClick(muserNameEditText.getText().toString(),
                mpasswordEditText.getText().toString());
        setLoginText("I love Yoki ");




    }


    @Override
    public void openMainActivity() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void setLoginText(String word) {
        accountTextView.setText(word);
    }

    @Override
    public void openDiaryActivity() {
        Intent intent = new Intent(this, DiaryActivity.class);
        startActivity(intent);
        finish();
    }


}
