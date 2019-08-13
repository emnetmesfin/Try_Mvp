package com.example.try_mvp.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.try_mvp.data.DataManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppPreferencesHelper implements PreferencesHelper{

   private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";
   private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    private static final String PREF_KEY_CURRENT_USER_PASSWORD = "PREF_KEY_CURRENT_USER_PASSWORD";
    private static final String PREF_KEY_CURRENT_USER_PROFILE_PIC_URL
            = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private final SharedPreferences mPrefs;

    //@Inject  //  // inject @ApplicationContext and @PreferenceInfo
    public AppPreferencesHelper( Context context,
                                String prefFileName){
        mPrefs = context.getSharedPreferences(prefFileName , Context.MODE_PRIVATE);

    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
    }

    @Override
    public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {
        mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE,mode.getType()).apply();
    }

    @Override
    public Long getCurrentUserId() {
        long userId = mPrefs.getLong(PREF_KEY_CURRENT_USER_ID,-1L);
        return userId == -1L ? null : userId;
    }

    @Override
    public void setCurrentUserId(Long userId) {
        long id = userId == null ? -1L : userId;
        mPrefs.edit().putLong(PREF_KEY_CURRENT_USER_ID,id).apply();
    }

    @Override
    public String getCurrentUserName() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_NAME,null);
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME,userName).apply();
    }

    @Override
    public String getCurrentUserPassword() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_PASSWORD,null);
    }

    @Override
    public void setCurrentUserPassword(String password) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_PASSWORD,password).apply();

    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL,null);
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL,profilePicUrl).apply();
    }

    @Override
    public String getAccessToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN , null);
    }

    @Override
    public void setAccessTocken(String accessTocken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN , accessTocken).apply();
    }
}
