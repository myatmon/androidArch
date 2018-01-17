package com.frontiir.arch.userarch.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.frontiir.arch.userarch.cache.UserCache;
import com.frontiir.arch.userarch.dao.UserDao;
import com.frontiir.arch.userarch.model.User;
import com.frontiir.arch.userarch.service.Webservice;

import java.io.IOException;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author monshein
 * @since 1/17/18
 */

public class UserRepository {
    private final Webservice webservice;
    private final UserDao userDao;
    private final Executor executor;

    @Inject
    public UserRepository(Webservice webservice,UserDao userDao,Executor executor){
        this.webservice = webservice;
        this.userDao = userDao;
        this.executor = executor;
    }



    public LiveData<User> getUser(String userId){
        refreshUser(userId);
        return userDao.load(userId);
    }

    private void refreshUser(String userId) {

        executor.execute(()->{
            boolean userExists = userDao.hasUser(3000);
            if(!userExists){
                try {
                    Response response = webservice.getUser(userId).execute();
                    userDao.save((User) response.body());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
