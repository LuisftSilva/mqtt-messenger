package luis.silva.mqttmessenger.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;
import java.util.Objects;

import luis.silva.mqttmessenger.R;
import luis.silva.mqttmessenger.model.AppDatabase;
import luis.silva.mqttmessenger.model.sensor.Sensor;

public class Home extends AppCompatActivity {

    private static final String TAG = "Home";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).hide();
        }

        this.setContentView(R.layout.activity_home);
        //Navigation.findNavController(findViewById(R.id.fragment)).navigate(R.id.type);

        Log.d(TAG, "Home onCreate: success");


        populateSensorWithData(AppDatabase.getAppDatabase(getBaseContext()));

        AppDatabase appDatabase = AppDatabase.getAppDatabase(getBaseContext());

        List<Sensor> sensor =
                appDatabase.sensorDao().getAll();

        Sensor user0 = sensor.get(0);

        System.out.println(sensor.size());
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        System.out.println(user0.getBroker());
        System.out.println(user0.getTopic());
        System.out.println(user0.getScale());
    }


    private static Sensor addSensor(final AppDatabase db, Sensor sensor) {
        db.sensorDao().insertAll(sensor);
        return sensor;
    }

    private static void populateSensorWithData(AppDatabase db) {
        Sensor sensor = new Sensor();
        sensor.setBroker("broker bla bla bla");
        sensor.setTopic("topic bla bla bla");
        sensor.setScale("C");
        addSensor(db, sensor);
    }

}
