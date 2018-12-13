package luis.silva.mqttmessenger.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import luis.silva.mqttmessenger.model.buttons.OnOffButton;
import luis.silva.mqttmessenger.model.buttons.OnOffButtonDao;
import luis.silva.mqttmessenger.model.sensor.Sensor;
import luis.silva.mqttmessenger.model.sensor.SensorDao;

@Database(entities = {Sensor.class, OnOffButton.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract SensorDao sensorDao();

    public abstract OnOffButtonDao onOffButtonDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user-database")

                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
