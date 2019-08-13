package com.example.try_mvp.db;

import android.database.Observable;

import java.util.List;

//
public interface DbHelper {

    Long insertUser(final User user);

    User getUser(Long id);

    List<User> getAllUsers();

    List<Diary> getAllDiary();

    Boolean saveDiary(Diary diary);

    Boolean saveDiaryList(List<Diary> diary);

    Diary getDiary(Long id);
}
