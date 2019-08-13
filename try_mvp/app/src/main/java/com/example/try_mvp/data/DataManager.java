package com.example.try_mvp.data;

import com.example.try_mvp.db.DbHelper;
import com.example.try_mvp.prefs.PreferencesHelper;

import java.util.Observable;

//  contain methods seedDatabaseDiaries and updateUserInfo

public interface DataManager extends DbHelper, PreferencesHelper { /*,ApiHelper*/

//    void updateApiHeader(Long userId, String accessToken);

    void setUserAsLoggedOut();

   public Boolean seedDatabseDiaries();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String UserName,
            String password);

    enum LoggedInMode{

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(1);

        private final int mType;

        LoggedInMode(int type){ mType = type; }

        public int getType(){ return mType; }
    }



}
