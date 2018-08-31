package com.example.rebelbob11.roomwithview;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {Word.class},version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao();


    //Making WordRoomDatabase Singleton

    public static WordRoomDatabase INSTANCE;
    public static WordRoomDatabase getWordRoomDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (WordRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.
                            databaseBuilder
                            (context.getApplicationContext(),
                                    WordRoomDatabase.class,
                                    "word_database")
                            .build();
                }
            }
        }

        return INSTANCE;
    }

}
