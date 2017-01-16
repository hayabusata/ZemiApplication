package com.example.zemiapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingActivity extends AppCompatActivity {
    private MyApp myApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        myApp = (MyApp)getApplication();

        RadioGroup levelRadioGroup = (RadioGroup)findViewById(R.id.level);
        if (myApp.getLevel() == 0) {
            RadioButton normalButton = (RadioButton)findViewById(R.id.normal);
            normalButton.setChecked(true);
        } else if (myApp.getLevel() == 1) {
            RadioButton easyButton = (RadioButton)findViewById(R.id.easy);
            easyButton.setChecked(true);
        } else if (myApp.getLevel() == 2) {
            RadioButton veryHardButton = (RadioButton)findViewById(R.id.veryHard);
            veryHardButton.setChecked(true);
        }

        levelRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.normal:
                        myApp.setLevel(0);
                        break;
                    case R.id.easy:
                        myApp.setLevel(1);
                        break;
                    case R.id.veryHard:
                        myApp.setLevel(2);
                        break;
                }
            }
        });
    }
}
