package com.frontiir.arch.userarch.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.frontiir.arch.userarch.dao.UserDao;
import com.frontiir.arch.userarch.model.User;

/**
 * @author monshein
 * @since 1/17/18
 */
@Database(entities = {User.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

}
