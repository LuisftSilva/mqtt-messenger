package luis.silva.mqttmessenger.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import luis.silva.mqttmessenger.R;

public class Type extends Fragment {

    private View view;
    private EditText broker, topic;
    private TextView create;
    private Context context;
    private Activity activity;
    private SharedPreferences sharedPreferences;
    private static final String TAG = "Type";


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_type, container, false);

       // sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);

        Log.d(TAG, "Type onCreateView: success");

        return view;
    }

}
