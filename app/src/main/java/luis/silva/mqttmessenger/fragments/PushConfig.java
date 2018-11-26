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

import luis.silva.mqttmessenger.R;

public class PushConfig  extends Fragment {

    private View view;
    private static final String TAG = "PushConfig";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_push_config, container, false);

        // sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);

        Log.d(TAG, "PushConfig onCreateView: success");

        return view;
    }
}
