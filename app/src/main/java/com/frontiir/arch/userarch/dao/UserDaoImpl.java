package com.frontiir.arch.userarch.dao;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.frontiir.arch.userarch.model.User;
import com.frontiir.arch.userarch.room.AppDatabase;

/**
 * @author monshein
 * @since 1/17/18
 */

public class UserDaoImpl implements UserDao {
    private SQLiteDatabase database;
    private AppDatabase appDatabase;
    private Context context;

    public UserDaoImpl(Context context){
        this.context = context;
    }

    public void open(){
        
    }


    @Override
    public void save(User user) {

    }

    @Override
    public LiveData<User> load(int userId) {
        return null;
    }
}
