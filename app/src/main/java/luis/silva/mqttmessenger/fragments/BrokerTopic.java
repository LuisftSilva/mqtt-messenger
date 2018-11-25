package luis.silva.mqttmessenger.fragments;

import android.app.Activity;
import android.content.Context;
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

public class BrokerTopic extends Fragment implements View.OnClickListener {

    private View view;
    private EditText broker, topic;
    private TextView create;
    private Context context;
    private Activity activity;
    private static final String TAG = "BrokerTopic";


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_broker_topic, container, false);

        Log.d(TAG, "BrokerTopic onCreateView: success");

        return view;
    }

    public void defineIds() {

        broker = view.findViewById(R.id.broker);
        topic = view.findViewById(R.id.topic);
        create = view.findViewById(R.id.create);

    }

    private void handleClick() {

        create.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

    }
}
