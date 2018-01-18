package com.frontiir.arch.userarch.repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.frontiir.arch.userarch.dao.UserDao;
import com.frontiir.arch.userarch.model.User;
import com.frontiir.arch.userarch.room.AppDataBaseImpl;
import com.frontiir.arch.userarch.service.Webservice;

import java.util.concurrent.Executor;


/**
 * @author monshein
 * @since 1/17/18
 */

public class UserRepository {
    public Webservice webservice;
    public final UserDao userDao;
    private Executor executor;

    public UserRepository(Context context, Executor executor) {
        this.userDao = AppDataBaseImpl.getAppDatabase(context).AppDatabase();
        this.executor = executor;
    }

    public LiveData<User> getUser(int userId) {
        refreshUser(userId);
        return userDao.load(userId);
    }

    private void refreshUser(int userId) {
        executor.execute(() -> {
            boolean userExists = false;
            if (!userExists) {
                User user = new User();
                user.setId(1);
                user.setName("Mon");
                user.setLastName("Shein");
                userDao.save(user);
            }
        });

    }
}
