package luis.silva.mqttmessenger.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.Objects;

import androidx.navigation.Navigation;
import luis.silva.mqttmessenger.R;

public class Home extends AppCompatActivity {

    private static final String TAG = "Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).hide();
        }

        this.setContentView(R.layout.activity_home);
        //Navigation.findNavController(findViewById(R.id.fragment)).navigate(R.id.type);

        Log.d(TAG, "Home onCreate: success");
    }
}
