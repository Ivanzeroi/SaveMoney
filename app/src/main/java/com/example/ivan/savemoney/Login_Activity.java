package com.example.ivan.savemoney;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Login_Activity extends AppCompatActivity {

    RelativeLayout really1,really2;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            really1.setVisibility(View.VISIBLE);
            really2.setVisibility(View.VISIBLE);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        really1 = (RelativeLayout) findViewById(R.id.really1);
        really2 = (RelativeLayout) findViewById(R.id.really2);

        handler.postDelayed(runnable,3000);
    }
}
