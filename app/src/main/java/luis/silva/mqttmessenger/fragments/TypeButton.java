package luis.silva.mqttmessenger.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;
import luis.silva.mqttmessenger.R;

import static android.support.constraint.Constraints.TAG;

public class TypeButton extends Fragment implements View.OnClickListener {

    private View view;
    private Button onOffButton, pushButton;
    private static final String TAG = "TypeButton";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_type_button, container, false);

        // sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);
        defineIds();
        handleClick();
        Log.d(TAG, "TypeButton onCreateView: success");

        return view;
    }

    private void defineIds() {

        onOffButton = view.findViewById(R.id.on_off_button);
        pushButton = view.findViewById(R.id.push_button);
    }

    private void handleClick() {

        onOffButton.setOnClickListener(this);
        pushButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == onOffButton) {

            Navigation.findNavController(getActivity().findViewById(R.id.fragment)).navigate(R.id.on_off_config);

        } else if (v == pushButton) {

            Navigation.findNavController(getActivity().findViewById(R.id.fragment)).navigate(R.id.push_config);

            //  } else if (v == potentiometer) {
        }
    }

}
