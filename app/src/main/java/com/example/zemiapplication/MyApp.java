package com.example.zemiapplication;

import android.app.Application;

/**
 * Created by syunta on 2017/01/12.
 */

public class MyApp extends Application {
    private int level;  //CPUの強さ　0:normal 1:hard

    @Override
    public void onCreate() {
        //this.level = 0;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int newLevel) {
        this.level = newLevel;
    }
}
