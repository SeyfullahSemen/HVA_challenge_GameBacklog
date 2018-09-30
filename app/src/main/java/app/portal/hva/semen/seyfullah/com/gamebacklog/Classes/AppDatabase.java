package app.portal.hva.semen.seyfullah.com.gamebacklog.Classes;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import app.portal.hva.semen.seyfullah.com.gamebacklog.Daos.GameDao;

/*
 * Created by Seyfullah Semen on 24-9-2018.
 */
@Database(entities = {Games.class}, version = 1 , exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract GameDao reminderDao();

    private final static String NAME_DATABASE = "game_db";

    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {

        if (sInstance == null) {

            sInstance = Room.databaseBuilder(context, AppDatabase.class, NAME_DATABASE).build();
        }


        return sInstance;
    }
}
