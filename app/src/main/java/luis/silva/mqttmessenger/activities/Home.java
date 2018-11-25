package luis.silva.mqttmessenger.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import androidx.navigation.Navigation;
import luis.silva.mqttmessenger.R;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        this.setContentView(R.layout.activity_home);
        //Navigation.findNavController(findViewById(R.id.fragment)).navigate(R.id.type);

        Log.d(TAG, "Home onCreate: success");
    }

    @Override
    public void onClick(View v) {

    }
}
