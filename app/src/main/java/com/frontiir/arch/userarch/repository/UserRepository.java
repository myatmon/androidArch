package com.frontiir.arch.userarch.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

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



    public LiveData<User> getUser(int userId){
        refreshUser(userId);
        return userDao.load(userId);
    }

    private void refreshUser(int userId) {
        Log.d("Repo ->","get user by Id ->"+ userId);
        User user = new User();
        user.setId(1);
        user.setName("Mon");
        user.setLastName("Shein");
        // userDao.save((User) response.body());
        userDao.save(user);
        executor.execute(()->{
            Log.d("Repo ->","get user by Id ->"+ userId);
            boolean userExists = false;
            if(!userExists){
                /*Response response = webservice.getUser(userId).execute();*/

                // userDao.save((User) response.body());
                userDao.save(user);
            }
        });

    }
}
