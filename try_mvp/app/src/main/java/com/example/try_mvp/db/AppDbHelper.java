package com.example.try_mvp.db;

import android.database.Observable;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton()
public class AppDbHelper implements DbHelper{

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper){
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }



    @Override
    public Long insertUser(User user) {
        return mDaoSession.getUserDao().insert(user);
    }

    @Override
    public User getUser(Long id) {
        return mDaoSession.getUserDao().load(id);
    }

    @Override
    public List<User> getAllUsers() {
        return mDaoSession.getUserDao().loadAll();
    }

    @Override
    public List<Diary> getAllDiary() {
        return mDaoSession.getDiaryDao().loadAll();
    }

    @Override
    public Boolean saveDiary(Diary diary) {
        mDaoSession.getDiaryDao().insertInTx(diary);
        return true;
    }

    @Override
    public Boolean saveDiaryList(List<Diary> diary) {
        mDaoSession.getDiaryDao().insertInTx(diary);
        return true;
    }

    @Override
    public Diary getDiary(Long id) {
        return mDaoSession.getDiaryDao().load(id);
    }
}
