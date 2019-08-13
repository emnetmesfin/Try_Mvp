package com.example.try_mvp.data;

import android.content.Context;

import com.example.try_mvp.db.DbHelper;
import com.example.try_mvp.db.Diary;
import com.example.try_mvp.db.User;
import com.example.try_mvp.prefs.PreferencesHelper;

import java.util.List;
import java.util.Observable;

public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mdbHelper;
    private final PreferencesHelper mPreferencesHelper;
//    private final ApiHelper mApiHelper;

    //  // Inject @ApplicationContext
    public AppDataManager(Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper
                         // ApiHelper apiHelper//
                           ){
        mContext = context;
        mdbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
    }

//    @Override
//    public ApiHeader getApiHeader() {
//        return mApiHelper.getApiHeader();
//    }


    @Override
    public void setUserAsLoggedOut(

    ) {

    }

    @Override
    public Boolean seedDatabseDiaries() {
        return null;
    }

    @Override
    public void updateUserInfo(String accessToken, Long userId, LoggedInMode loggedInMode, String UserName, String password) {

    }

    @Override
    public Long insertUser(User user) {
        return mdbHelper.insertUser(user);
    }

    @Override
    public User getUser(Long id) {
        return mdbHelper.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return mdbHelper.getAllUsers();
    }

    @Override
    public List<Diary> getAllDiary() {
        return mdbHelper.getAllDiary();
    }

    @Override
    public Boolean saveDiary(Diary diary) {
        return null;
    }

    @Override
    public Boolean saveDiaryList(List<Diary> diary) {
        return null;
    }

    @Override
    public Diary getDiary(Long id) {
        return null;
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserPassword() {
        return mPreferencesHelper.getCurrentUserPassword();
    }

    @Override
    public void setCurrentUserPassword(String password) {
        mPreferencesHelper.setCurrentUserPassword(password);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return null;
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {

    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessTocken(String accessTocken) {

    }
}
