package com.example.mqttmessenger;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private EditText room;
    private TextView button;
    private Context context;
    private String Name, Room;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_main);
        defineIds();
        handleClick();

    }

    private void defineIds() {
        button = findViewById(R.id.login);
        name = findViewById(R.id.name);
        room = findViewById(R.id.room);

    }


    private void handleClick() {
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Name = name.getText().toString().trim();
        Room = room.getText().toString().trim();

        System.out.println(Name);
        System.out.println(Room);

        if (v == button) {
            sharedPreferences.edit().putString("name",Name).apply();
            sharedPreferences.edit().putString("room",Room).apply();
            Intent intent = new Intent(context, Messenger.class);
            startActivity(intent);
            finish();

        }
    }
}
