package com.frontiir.arch.userarch.model;

import android.arch.lifecycle.ViewModel;


/**
 * @author monshein
 * @since 1/16/18
 */

public class UserProfileViewModel extends ViewModel {

    private String userId;
    private User user;

    public void init(String userId){
        this.userId = userId;
    }

    public User getUser(){
        return user;
    }
}
