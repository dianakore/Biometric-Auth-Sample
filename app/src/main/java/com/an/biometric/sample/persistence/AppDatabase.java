package com.an.biometric.sample.persistence;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * The Room database that contains the Device table
 */
@Database(entities = {Device.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract DeviceDao deviceDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "Monitoring.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallBack)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallBack =  new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private DeviceDao deviceDao;

        private PopulateDbAsyncTask(AppDatabase db){
            deviceDao=db.deviceDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            /*Questo verrà sostituito con la chiamata al
             ws sul BE del monitoring*/
            deviceDao.insert(new Device("357520076361274"));
            deviceDao.insert(new Device("357520076361275"));
            deviceDao.insert(new Device("357520076361276"));
            return null;
        }
    }
}
