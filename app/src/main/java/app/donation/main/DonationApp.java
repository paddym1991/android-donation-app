package app.donation.main;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import app.donation.model.Donation;
import app.donation.model.User;

public class DonationApp extends Application
{
    public final int       target       = 10000;
    public int             totalDonated = 0;
    public List <Donation> donations    = new ArrayList<Donation>();
    public List <User>     users        = new ArrayList<User>();

    public void newUser(User user)
    {
        users.add(user);
    }

    public boolean validUser (String email, String password)
    {
        for (User user : users)
        {
            if (user.email.equals(email) && user.password.equals(password))
            {
                return true;
            }
        }
        return false;
    }

    public boolean newDonation(Donation donation)
    {
        boolean targetAchieved = totalDonated > target;
        if (!targetAchieved)
        {
            donations.add(donation);
            totalDonated += donation.amount;
        }
        else
        {
            Toast toast = Toast.makeText(this, "Target Exceeded!", Toast.LENGTH_SHORT);
            toast.show();
        }
        return targetAchieved;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.v("Donate", "Donation App Started");
    }
}