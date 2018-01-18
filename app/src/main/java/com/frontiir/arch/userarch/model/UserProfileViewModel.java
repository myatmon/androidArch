package com.frontiir.arch.userarch.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.frontiir.arch.userarch.repository.UserRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * @author monshein
 * @since 1/16/18
 */

public class UserProfileViewModel extends AndroidViewModel {

    private final Executor executor = Executors.newFixedThreadPool(2);
    private int userId;
    private UserRepository userRepo = new UserRepository(this.getApplication(), executor);
    //private User user; change LiveData to user

    private LiveData<User> user;

    public UserProfileViewModel(@NonNull Application application) {
        super(application);
        init(1);
    }

    public void init(int userId) {
        if (this.user != null) {
            return;
        }
        user = userRepo.getUser(userId);
    }

    public LiveData<User> getUser() {
        return user;
    }
}
