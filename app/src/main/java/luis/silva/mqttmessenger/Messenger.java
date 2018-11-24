package luis.silva.mqttmessenger;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.mqttmessenger.R;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Messenger extends AppCompatActivity implements View.OnClickListener, MqttCallback {

    private View view;
    private Context context;
    private MqttClient client;
    private String broker = "tcp://broker.hivemq.com:1883";
    private String clientId1 = "user", message;
    private MemoryPersistence persistence = new MemoryPersistence();
    private String topic = "";
    private String name = "";
    private MqttMessage mqttMessage = new MqttMessage();
    private SharedPreferences sharedPreferences;
    private TextView send, conversation, boxtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irrigation);
        context = Messenger.this;
        defineIds();
        handleClick();
        sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);
        topic = sharedPreferences.getString("room", "");
        name = sharedPreferences.getString("name", "");
        createMqttClient();
        hideKeyboard(this);

    }


    private void defineIds() {

        conversation = findViewById(R.id.conversation);
        boxtext = findViewById(R.id.box_txt);
        send = findViewById(R.id.send);
        conversation.setFocusable(false);
    }

    private void handleClick() {

        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        message = boxtext.getText().toString().trim();

        if (v == send) {

            System.out.println(message);

            System.out.println(name);

            message = name + " :  " + message;

            sendMqttMessage(message);
            boxtext.setText("");


             //   conversation.setText(conversation.getText() + "  " + message);


        }
    }

    public void sendMqttMessage(String string) {

        try {
            mqttMessage.setPayload(string.getBytes());
            client.publish(topic, mqttMessage);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void createMqttClient() {
        try {
            client = new MqttClient(broker, clientId1, persistence);
            client.setCallback(this);
            client.connect();
            client.subscribe(topic);
           // client.close();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public static void hideKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void connectionLost(Throwable cause) {

    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {

        final String payload = new String(message.getPayload());
        //conversation.setText(conversation.getText() + " " + payload);


        new Thread(new Runnable() {
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                       // conversation.setText(conversation.getText() + "\n" + payload);
                        conversation.setText(payload);

                    }
                });
            }
        }).start();
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }
}
