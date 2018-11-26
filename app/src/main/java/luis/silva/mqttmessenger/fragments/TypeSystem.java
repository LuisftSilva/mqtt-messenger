package luis.silva.mqttmessenger.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.navigation.Navigation;
import luis.silva.mqttmessenger.R;

public class TypeSystem extends Fragment implements View.OnClickListener {

    private View view;
    private EditText broker, topic;
    private TextView create;
    private Context context;
    private Activity activity;
    private SharedPreferences sharedPreferences;
    private ConstraintLayout button, temperatureSensor, potentiometer;
    private static final String TAG = "TypeSystem";


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_type_system, container, false);

        // sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);

        Log.d(TAG, "Type onCreateView: success");
        defineIds();
        handleClick();
        return view;
    }

    private void defineIds() {

        button = view.findViewById(R.id.button);
        temperatureSensor = view.findViewById(R.id.temperature_sensor);
        potentiometer = view.findViewById(R.id.potentiometer);
    }

    private void handleClick() {

        button.setOnClickListener(this);
        temperatureSensor.setOnClickListener(this);
        potentiometer.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == button) {

            Navigation.findNavController(getActivity().findViewById(R.id.fragment)).navigate(R.id.type_button);

        } else if (v == temperatureSensor) {



        } else if (v == potentiometer) {



        }
    }
}
