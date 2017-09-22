package app.donation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Paddym1991 on 22/09/2017.
 */

public class Welcome extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void loginButtonPressed (View view) {
        startActivity(new Intent(this, Donate.class));
    }

    public void signupButtonPressed (View view) {
        startActivity(new Intent(this, Donate.class));
    }
}

