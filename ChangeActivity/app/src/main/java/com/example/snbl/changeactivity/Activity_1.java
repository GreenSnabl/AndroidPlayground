package com.example.snbl.changeactivity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_1 extends AppCompatActivity {

    private static int cnt;
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        getSupportActionBar().setTitle("Hehe");

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        button2 = (Button) findViewById(R.id.button_frag);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePicture();
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MyFragment()).commit();
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Activity_2.class);
        startActivity(intent);
    }

    public void changePicture() {

        Fragment selectedFragment = null;
        cnt = (cnt + 1) % 2;

        switch(cnt) {
            case 0:
                selectedFragment = new MyFragment();
                getSupportActionBar().setTitle("MoxNox");
                break;
            case 1:
                selectedFragment = new MyFragment2();
                getSupportActionBar().setTitle("Dolan");
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, selectedFragment).commit();
    }


}
