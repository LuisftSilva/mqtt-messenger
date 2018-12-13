package luis.silva.mqttmessenger.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;
import java.util.Objects;

import luis.silva.mqttmessenger.R;
import luis.silva.mqttmessenger.model.AppDatabase;
import luis.silva.mqttmessenger.model.buttons.OnOffButton;
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


       // populateSensorWithData(AppDatabase.getAppDatabase(getBaseContext()));

       // populateOnOffButtonWithData(AppDatabase.getAppDatabase(getBaseContext()));

        AppDatabase appDatabase = AppDatabase.getAppDatabase(getBaseContext());

        List<Sensor> sensor =
                appDatabase.sensorDao().getAll();

        Sensor user0 = sensor.get(0);

        System.out.println(sensor.size());
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        System.out.println(user0.getBroker());
        System.out.println(user0.getTopic());
        System.out.println(user0.getScale());

        List<OnOffButton> onOffButtons =
                appDatabase.onOffButtonDao().getAll();

        OnOffButton user1 = onOffButtons.get(0);

        System.out.println(onOffButtons.size());
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        System.out.println(user1.getBroker());
        System.out.println(user1.getTopic());
        System.out.println(user1.getOnCommand());
        System.out.println(user1.getOffCommand());
        System.out.println(user1.getFeedback());
        System.out.println(user1.getFeedbackTopic1());
        System.out.println(user1.getFeedbackMessage1());
        System.out.println(user1.getFeedbackTopic2());
        System.out.println(user1.getFeedbackMessage2());
    }


    private static Sensor addSensor(final AppDatabase db, Sensor sensor) {
        db.sensorDao().insertAll(sensor);
        return sensor;
    }

    private static OnOffButton addOnOffButton(final AppDatabase db, OnOffButton onOffButton) {
        db.onOffButtonDao().insertAll(onOffButton);
        return onOffButton;
    }

    private static void populateSensorWithData(AppDatabase db) {
        Sensor sensor = new Sensor();
        sensor.setBroker("broker bla bla bla");
        sensor.setTopic("topic bla bla bla");
        sensor.setScale("C");
        addSensor(db, sensor);
    }

    private static void populateOnOffButtonWithData(AppDatabase db) {
        OnOffButton onOffButton = new OnOffButton();
        onOffButton.setBroker("broker.hivemq.com");
        onOffButton.setTopic("light1234down");
        onOffButton.setOnCommand("1");
        onOffButton.setOffCommand("0");
        onOffButton.setFeedback("1");
        onOffButton.setFeedbackTopic1("1");
        onOffButton.setFeedbackMessage1("1");
        onOffButton.setFeedbackTopic2("0");
        onOffButton.setFeedbackMessage2("0");
        addOnOffButton(db, onOffButton);
    }

}
