package com.example.snbl.fragmentbottomnav;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class main extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setSelectedItemId(R.id.nav_remote);


        bottomNav.setOnNavigationItemSelectedListener(navListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RemoteFragment()).commit();



    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch(item.getItemId()) {
                        case R.id.nav_remote:
                            selectedFragment = new RemoteFragment();
                            getSupportActionBar().setTitle("Remote");
                            break;
                        case R.id.nav_settings:
                            selectedFragment = new SettingsFragment();
                            getSupportActionBar().setTitle("Settings");
                            break;
                        case R.id.nav_channels:
                            selectedFragment = new ChannelsFragment();
                            getSupportActionBar().setTitle("Channels");
                            break;
                        case R.id.nav_recorder:
                            selectedFragment = new RecorderFragment();
                            getSupportActionBar().setTitle("Recorder");
                            break;
                        case R.id.nav_picture_in_picture:
                            selectedFragment = new PictureInPictureFragment();
                            getSupportActionBar().setTitle("Picture in Picture");
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };

}
