package com.example.zemiapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button startButton, settingButton;
    MyApp myApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.gameStart);
        startButton.setOnClickListener(this);

        settingButton = (Button)findViewById(R.id.setting);
        settingButton.setOnClickListener(this);

        myApp = (MyApp)getApplication();
        myApp.setLevel(0);
    }

    public void onClick(View v) {
        if (v == startButton) {
            Intent intent = new Intent(getApplication(), GameActivity.class);
            startActivity(intent);
        } else if (v == settingButton) {
            Intent intent = new Intent(getApplication(), SettingActivity.class);
            startActivity(intent);
        }
    }
}
