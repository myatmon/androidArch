package com.frontiir.arch.userarch.room;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * @author monshein
 * @since 1/17/18
 */

public class AppDataBaseImpl {

    private static AppDatabase appDatabase;
    private static final Object LOCK = new Object();

    public synchronized static AppDatabase getAppDatabase(Context context){
        if(appDatabase == null){
            synchronized (LOCK){
                if(appDatabase == null){
                    appDatabase = Room.databaseBuilder(context,AppDatabase.class,"my_add_db").build();
                }
            }
        }
        return appDatabase;
    }
}
