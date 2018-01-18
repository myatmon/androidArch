package com.frontiir.arch.userarch.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.frontiir.arch.userarch.model.User;

/**
 * @author monshein
 * @since 1/17/18
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(User user);

    @Query("SELECT * FROM user WHERE id = :userId")
    LiveData<User> load(int userId);
}
