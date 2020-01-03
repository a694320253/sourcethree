package com.usho.rain_enoje;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private  RainView rainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rainView=findViewById(R.id.rainView);
    }

    public void startDog(View view) {
        rainView.setImgRes(R.mipmap.dog);
        rainView.start(true);
    }

    public void startCoke(View view) {
        rainView.setImgRes(R.mipmap.cake);;
        rainView.start(true);
    }
}
