package luis.silva.mqttmessenger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {

    private EditText broker;
    private EditText topic;
    private TextView button;
    private Context context;
    private String Name, Room;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);
       // setContentView(R.layout.activity_main);
        defineIds();
        handleClick();

    }

    private void defineIds() {
        //button = findViewById(R.id.login);
        broker = findViewById(R.id.broker);
        topic = findViewById(R.id.topic);

    }


    private void handleClick() {
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == button) {
            sharedPreferences.edit().putString("broker",broker.getText().toString().trim()).apply();
            sharedPreferences.edit().putString("topic",topic.getText().toString().trim()).apply();
            Intent intent = new Intent(context, Messenger.class);
            startActivity(intent);
            finish();

        }
    }
}
