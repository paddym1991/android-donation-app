package app.donation;

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
        Toast.makeText(this, "Login Selected", Toast.LENGTH_SHORT).show();
    }

    public void signupButtonPressed (View view) {
        Toast.makeText(this, "Signup Selected", Toast.LENGTH_SHORT).show();
    }
}

