package luis.silva.mqttmessenger.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.navigation.Navigation;
import luis.silva.mqttmessenger.R;

public class Systems extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView menu;
    private static final String TAG = "Systems";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_systems, container, false);

        // sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);
        defineIds();
        handleClick();
        Log.d(TAG, "Systems onCreateView: success");
        return view;
    }

    private void defineIds() {

        menu = view.findViewById(R.id.menu);

    }

    private void handleClick() {

        menu.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v == menu) {

            Navigation.findNavController(getActivity().findViewById(R.id.fragment)).navigate(R.id.type_system);

        }
    }
}
