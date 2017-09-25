package app.donation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import app.donation.main.DonationApp;
import app.donation.R;
import app.donation.model.User;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void signupButtonPressed (View view)
    {
        TextView firstName = (TextView)  findViewById(R.id.FirstName);
        TextView lastName  = (TextView)  findViewById(R.id.LastName);
        TextView email     = (TextView)  findViewById(R.id.Email);
        TextView password  = (TextView)  findViewById(R.id.Password);

        User user = new User (firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), password.getText().toString());

        DonationApp app = (DonationApp) getApplication();
        app.newUser(user);

        startActivity (new Intent(this, Welcome.class));
    }
}

