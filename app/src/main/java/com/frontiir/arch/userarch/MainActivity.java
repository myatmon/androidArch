package com.frontiir.arch.userarch;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.frontiir.arch.userarch.model.User;
import com.frontiir.arch.userarch.model.UserProfileViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txvName = findViewById(R.id.txv_name);

        UserProfileViewModel userProfileViewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        userProfileViewModel.getUser().observe(this, user -> {
            txvName.setText("Developer name is " + user.getName() + user.getLastName());
        });
    }
}
