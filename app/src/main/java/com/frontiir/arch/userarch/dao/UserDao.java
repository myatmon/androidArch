package com.frontiir.arch.userarch.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Room;

import com.frontiir.arch.userarch.model.User;

import java.lang.reflect.ReflectPermission;

/**
 * @author monshein
 * @since 1/17/18
 */
@Dao
public interface UserDao {
    @Insert()
    void save(User user);

    @Query("SELECT * FROM user WHERE id = :userId")
    LiveData<User> load(String userId);

    boolean hasUser(int i);
}
