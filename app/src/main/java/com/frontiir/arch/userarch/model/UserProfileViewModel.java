package com.frontiir.arch.userarch.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.frontiir.arch.userarch.repository.UserRepository;


/**
 * @author monshein
 * @since 1/16/18
 */

public class UserProfileViewModel extends ViewModel {

    private String userId;

    private UserRepository userRepo;
    //private User user; change LiveData to user

    private LiveData<User> user;

    public void init(String userId){
        if(this.user != null){
            return;
        }
        user = userRepo.getUser(userId);
    }

    public LiveData<User> getUser(){
        return user;
    }
}
