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
import android.widget.EditText;
import android.widget.TextView;

import androidx.navigation.Navigation;
import luis.silva.mqttmessenger.R;

public class OnOffConfig extends Fragment implements View.OnClickListener {

    private View view;
    private Button feedbackButton, createButton;
    private TextView brokerTextView, topicTextView, onCommandTextView, offCommandTextView;
    private EditText brokerEditText;
    private static final String TAG = "OnOffConfig";


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_on_off_config, container, false);

        // sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);
        defineIds();
        handleClick();
        Log.d(TAG, "OnOffConfig onCreateView: success");

        return view;
    }

    private void defineIds() {

        feedbackButton = view.findViewById(R.id.feedback_button);
        createButton = view.findViewById(R.id.createButton);
        brokerEditText = view.findViewById(R.id.brokerEditText);
        topicTextView = view.findViewById(R.id.topicTextView);
        onCommandTextView = view.findViewById(R.id.onCommandTextView);
        offCommandTextView = view.findViewById(R.id.offCommandTextView);

    }

    private void handleClick() {

        feedbackButton.setOnClickListener(this);
        createButton.setOnClickListener(this);
        brokerEditText.setOnClickListener(this);
        topicTextView.setOnClickListener(this);
        onCommandTextView.setOnClickListener(this);
        offCommandTextView. setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {

        if (v == feedbackButton) {

            System.out.println(brokerEditText.getText());
            Navigation.findNavController(getActivity().findViewById(R.id.fragment)).navigate(R.id.feedback);

        }
    }
}
