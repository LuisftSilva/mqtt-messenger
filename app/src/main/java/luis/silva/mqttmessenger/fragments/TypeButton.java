package luis.silva.mqttmessenger.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import luis.silva.mqttmessenger.R;

import static android.support.constraint.Constraints.TAG;

public class TypeButton extends Fragment {

    private View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_type_button, container, false);

        // sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);

        Log.d(TAG, "TypeButton onCreateView: success");

        return view;
    }

}
